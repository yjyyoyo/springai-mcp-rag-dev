package com.itzixi.controller;

import com.itzixi.bean.ChatEntity;
import com.itzixi.service.ChatService;
import com.itzixi.service.DocumentService;
import com.itzixi.service.SesrXngService;
import com.itzixi.utils.LeeResult;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName HelloController
 * @Author 风间影月
 * @Version 1.0
 * @Description HelloController
 **/
@RestController
@RequestMapping("internet")
public class InternetController {

    @Resource
    private SesrXngService sesrXngService;

    @Resource
    private ChatService chatService;

    @GetMapping("/test")
    public Object test(@RequestParam("query") String query){
        return sesrXngService.search(query);
    }

    @PostMapping("/search")
    public void search(@RequestBody ChatEntity chatEntity, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        chatService.doInternetSearch(chatEntity);
    }

}
