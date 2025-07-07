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
@Data
@ToString
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