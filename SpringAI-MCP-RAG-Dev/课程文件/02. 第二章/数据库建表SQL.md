1. 创建数据库（步骤略）

2. 复制下方脚本到mysql中执行
```
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
`product_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品编号',
`product_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品名称',
`brand` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '品牌',
`price` int NOT NULL COMMENT '销售价格(单位：分)',
`stock` int unsigned NOT NULL DEFAULT '0' COMMENT '库存数量',
`description` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品简介',
`status` int NOT NULL DEFAULT '1' COMMENT '状态(0-下架 1-上架 2-预售)',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品表';

SET FOREIGN_KEY_CHECKS = 1;
```
