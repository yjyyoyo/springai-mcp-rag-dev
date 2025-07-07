package com.itzixi.service;

import com.itzixi.bean.ChatEntity;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.document.Document;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ChatService {

    /**
     * @Description: 测试大模型交互聊天
     * @Author 风间影月
     * @param prompt
     * @return String
     */
    public String chatTest(String prompt);

    /**
     * @Description: 测试大模型流式交互聊天(流式响应JSON)
     * @Author 风间影月
     * @param prompt
     * @return Flux<ChatResponse>
     */
    public Flux<ChatResponse> streamResponse(String prompt);

    /**
     * @Description: 测试大模型流式交互聊天(流式响应String)
     * @Author 风间影月
     * @param prompt
     * @return Flux<ChatResponse>
     */
    public Flux<String> streamStr(String prompt);

    /**
     * @Description: 和大模型交互
     * @Author 风间影月
     * @param chatEntity
     */
    public void doChat(ChatEntity chatEntity);

    /**
     * @Description: Rag知识库检索汇总给大模型输出
     * @Author 风间影月
     * @param chatEntity
     * @param ragContext
     */
    public void doChatRagSearch(ChatEntity chatEntity, List<Document> ragContext);

    /**
     * @Description: 基于searxng的实时联网搜索
     * @Author 风间影月
     * @param chatEntity
     */
    public void doInternetSearch(ChatEntity chatEntity);
}
