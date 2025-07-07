# SpringAI 集成sdtio与SSE类型MCP

```
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-mcp-client</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-mcp</artifactId>
</dependency>
```

```
spring:
  ai:
    mcp:
      client:
        enabled: true
        name: spring-ai-mcp-client-1.0.0
        type: ASYNC
        sse:
          connections:
            server1:
              url: https://mcp.amap.com
              sse-endpoint: /sse?key=09557e21174fff33be82c6cf0fa2cbcb
        stdio:
          servers-configuration: classpath:mcp-server.json
```

```
// 构造器注入，自动配置方式（推荐）
public ChatServiceImpl(ChatClient.Builder chatClientBuilder, ToolCallbackProvider tools) {
    this.chatClient = chatClientBuilder
            .defaultToolCallbacks(tools)
//                .defaultSystem(systemPrompt)
.build();
}
```