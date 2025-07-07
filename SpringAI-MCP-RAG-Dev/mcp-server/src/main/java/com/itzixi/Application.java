package com.itzixi;

import com.itzixi.mcp.tool.DateTool;
import com.itzixi.mcp.tool.EmailTool;
import com.itzixi.mcp.tool.ProductTool;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName Application
 * @Author 风间影月
 * @Version 1.0
 * @Description Application
 **/
@MapperScan("com.itzixi.mapper")
@SpringBootApplication
public class Application {

//    http://localhost:9060/sse

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 注册MCP工具
     */
    @Bean
    public ToolCallbackProvider registMCPTools(DateTool dateTool, EmailTool emailTool, ProductTool productTool) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(dateTool, emailTool, productTool)
                .build();
    }

}
