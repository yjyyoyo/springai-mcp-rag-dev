package com.itzixi.service.impl;

import cn.hutool.json.JSONUtil;
import com.itzixi.bean.SearXNGResponse;
import com.itzixi.bean.SearchResult;
import com.itzixi.service.SesrXngService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName SesrXngServiceImpl
 * @Author 风间影月
 * @Version 1.0
 * @Description SesrXngServiceImpl
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class SesrXngServiceImpl implements SesrXngService {

    @Value("${internet.websearch.searxng.url}")
    private String SEARXNG_URL;

    @Value("${internet.websearch.searxng.counts}")
    private Integer COUNTS;

    private final OkHttpClient okHttpClient;

    @Override
    public List<SearchResult> search(String query) {

        // 构建url
        HttpUrl url = HttpUrl.get(SEARXNG_URL)
                .newBuilder()
                .addQueryParameter("q", query)
                .addQueryParameter("format", "json")
                .build();

        log.info("搜索的url地址为：" + url.url());

        // 构建request
        Request request = new Request.Builder()
                .url(url)
                .build();

        // 发送请求
        try (Response response = okHttpClient.newCall(request).execute()) {

            // 判断请求是否成功还是失败
            if (!response.isSuccessful()) throw new RuntimeException("请求失败: HTTP " + response.code());

            // 获得响应的数据
            if (response.body() != null) {
                String responseBody = response.body().string();

                SearXNGResponse searXNGResponse = JSONUtil.toBean(responseBody, SearXNGResponse.class);

                return dealResults(searXNGResponse.getResults());
            }
            log.error("搜索失败：{}", response.message());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Collections.emptyList();
    }

    /**
     * @Description: 处理结果集，截取限制的个数
     * @Author 风间影月
     * @param results
     * @return List<SearchResult>
     */
    private List<SearchResult> dealResults(List<SearchResult> results) {

        return results.subList(0, Math.min(COUNTS, results.size()))
                        .parallelStream()
                        .sorted(Comparator.comparingDouble(SearchResult::getScore).reversed())
                        .limit(COUNTS).toList();
    }
}
