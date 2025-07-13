package com.itzixi.utils;

import com.itzixi.enums.SSEMsgType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @ClassName SSEServer
 * @Author 风间影月
 * @Version 1.0
 * @Description SSEServer
 **/
@Slf4j
public class SSEServer {

    //一、存放所有用户，使用线程安全的ConcurrentHashMap存储用户ID与SSEmitter的映射关系，管理所有活跃连接。
    private static final Map<String, SseEmitter> sseClients = new ConcurrentHashMap<>();

    /**
     * @Description: 连接SSE服务
     * @Author 风间影月
     * @param userId
     * @return SseEmitter
     */
    //二、连接管理
    public static SseEmitter connect(String userId) {

        // 设置超时时间，0L表示不超时（永不过期）；默认是30秒，超时未完成任务则会抛出异常
        //创建永不超时的SseEmitter对象
        SseEmitter sseEmitter = new SseEmitter(0L);

        // 注册回调方法：超时(OnTimeout)，完成(onCompletion),错误(onError)，均在触发时移除连接。
        sseEmitter.onTimeout(timeoutCallback(userId));
        sseEmitter.onCompletion(completionCallback(userId));
        sseEmitter.onError(errorCallback(userId));
        //将新连接存入Map并记录日志
        sseClients.put(userId, sseEmitter);

        log.info("SSE连接创建成功，连接的用户ID为：{}", userId);

        return sseEmitter;
    }
    //三、消息推送
    //3.1单播推送：向指定userId发送消息，使用SSEMsgType区分事件类型(如通知、心跳等)。
    public static void sendMsg(String userId, String message, SSEMsgType msgType) {
        //客户端的活跃连接为Null，直接返回
        if (CollectionUtils.isEmpty(sseClients)) {
            return;
        }
        //如果包含客户端Id，发送单条消息
        if (sseClients.containsKey(userId)) {
            SseEmitter sseEmitter = sseClients.get(userId);
            sendEmitterMessage(sseEmitter, userId, message, msgType);
        }

    }
    //3.2广播推送 遍历所有连接，向每个客户端发送消息
    public static void sendMsgToAllUsers(String message) {

        if (CollectionUtils.isEmpty(sseClients)) {
            return;
        }

        sseClients.forEach((userId, sseEmitter) -> {
                sendEmitterMessage(sseEmitter, userId, message, SSEMsgType.MESSAGE);
            }
        );
    }
    //3.3底层发送逻辑 构造符合SSE协议的事件流(含id,data,name字段)，异常时移除连接。
    private static void sendEmitterMessage(SseEmitter sseEmitter,
                                          String userId,
                                          String message,
                                          SSEMsgType msgType) {

        try {
            SseEmitter.SseEventBuilder msgEvent = SseEmitter.event()
                    .id(userId)
                    .data(message)
                    .name(msgType.type);
            sseEmitter.send(msgEvent);
        } catch (IOException e) {
            log.error("SSE异常...{}", e.getMessage());
            remove(userId);
        }

    }
    //四、回调与清理
    //4.1 超时/完成/错误回调；统一调用remove(userId)清理无效连接并释放连接
    public static Consumer<Throwable> errorCallback(String userId) {
        return Throwable -> {
            log.error("SSE异常...");
            // 移除用户连接
            remove(userId);
        };
    }

    public static Runnable timeoutCallback(String userId) {
        return () -> {
            log.info("SSE超时...");
            // 移除用户连接
            remove(userId);
        };
    }

    public static Runnable completionCallback(String userId) {
        return () -> {
            log.info("SSE完成...");
            // 移除用户连接
            remove(userId);
        };
    }

    //4.2 连接移除 从Map中删除连接并记录日志
    public static void remove(String userId) {
        // 删除用户
        sseClients.remove(userId);
        log.info("SSE连接被移除，移除的用户ID为：{}", userId);
    }


}
