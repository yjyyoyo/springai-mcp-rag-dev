package com.itzixi.controller;

import com.itzixi.bean.ChatEntity;
import com.itzixi.service.ChatService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * @ClassName HelloController
 * @Author 风间影月
 * @Version 1.0
 * @Description HelloController
 **/
@RestController
@RequestMapping("chat")
public class ChatController {


    @Resource
    private ChatService chatService;

    @PostMapping("doChat")
    public void doChat(@RequestBody ChatEntity chatEntity){
        chatService.doChat(chatEntity);
    }

}
