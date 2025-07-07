# Maven打包插件的构建与使用
在需要打包的工程里的pom中加上如下：

```
<build>
    <finalName>${project.artifactId}</finalName>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

打包 - 上传 - 启动

```
nohup java -jar mcp-server.jar >my-server.log 2>&1 &
nohup java -jar mcp-client.jar >my-client.log 2>&1 &
```

nohup = no hang up


101.32.223.87:8888/sse
