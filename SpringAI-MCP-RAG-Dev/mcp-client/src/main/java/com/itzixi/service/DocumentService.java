package com.itzixi.service;

import com.itzixi.bean.ChatEntity;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.document.Document;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Flux;

import java.util.List;

public interface DocumentService {

    /**
     * @Description: 加载文档并且读取数据进行保存到知识库
     * @Author 风间影月
     * @param resource
     * @param fileName
     */
    public List<Document> loadText(Resource resource, String fileName);

    /**
     * @Description: 根据提问从知识库中查询相应的知识/资料（相似）
     * @Author 风间影月
     * @param question
     * @return List<Document>
     */
    public List<Document> doSearch(String question);

}
