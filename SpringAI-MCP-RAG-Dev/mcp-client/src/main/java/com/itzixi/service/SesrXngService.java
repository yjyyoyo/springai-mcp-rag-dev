package com.itzixi.service;

import com.itzixi.bean.SearchResult;
import org.springframework.ai.document.Document;
import org.springframework.core.io.Resource;

import java.util.List;

public interface SesrXngService {

    /**
     * @Description: 调用本地搜索引擎searxng进行搜索
     * @Author 风间影月
     * @param query
     * @return List<SearchResult>
     */
    public List<SearchResult> search(String query);

}
