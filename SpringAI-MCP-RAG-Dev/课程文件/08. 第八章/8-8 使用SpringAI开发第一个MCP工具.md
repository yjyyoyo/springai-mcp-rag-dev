# 使用SpringAI开发第一个MCP工具

```
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-mcp-server-webflux</artifactId>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.17.0</version>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

```
server:
  port: 8090  # 服务器端口配置

spring:
  ai:
    mcp:
      server:
        name: spring-ai-mcp-server-sse    # MCP服务器名称
        version: 1.0.0                # 服务器版本号
        type: ASYNC #异步
```