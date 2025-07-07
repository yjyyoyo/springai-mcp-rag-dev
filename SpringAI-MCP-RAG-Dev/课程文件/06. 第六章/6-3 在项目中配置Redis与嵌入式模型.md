# 在项目中配置Redis与嵌入式模型

```
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-advisors-vector-store</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-vector-store-redis</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-model-transformers</artifactId>
</dependency>

<!--解析文档-->
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-tika-document-reader</artifactId>
</dependency>
```


```
spring:
  data:
    redis:
      host: 127.0.0.1
      port: 8379
      password: 123456
  ai:
    vectorstore:
      redis:
        initialize-schema: true         # 是否初始化所需的模式
        index-name: lee-vectorstore     # 用于存储向量的索引名称
        prefix: 'embedding:'             # Redis 键的前缀
```