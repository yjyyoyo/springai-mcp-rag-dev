package com.itzixi.pojo;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @ClassName Product
 * @Author 风间影月
 * @Version 1.0
 * @Description Product
 **/
@Data  //自动生成 Getter/Setter/toString()等方法。
@ToString //重写 toString()便于日志输出。
//ORM 框架（如 MyBatis-Plus）的操作对象，直接与数据库交互
public class Product {
    private String productId;
    private String productName;
    private String brand;
    private String description;

    private Integer price;
    private Integer stock;
    private Integer status;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}