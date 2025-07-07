# SpringBoot3集成MyBatisPlus

```
<!-- 数据库 MySql 的坐标 -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>

<!-- MyBatis-Plus 的坐标 -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.10.1</version>
    <exclusions>
        <exclusion>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>3.0.4</version>
</dependency>
```

```
spring:
  datasource: # 数据源的相关配置
    type: com.zaxxer.hikari.HikariDataSource      # 数据源的类型，可以更改为其他的数据源配置，比如druid
    driver-class-name: com.mysql.cj.jdbc.Driver      # mysql/MariaDB 的数据库驱动类名称
    url: jdbc:mysql://127.0.0.1:3306/springai-items-mcp?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
    username: root
    password: root
    hikari:
      pool-name: DataSourceHikariCP           # 连接池的名字
      connection-timeout: 30000               # 等待连接池分配连接的最大时间（毫秒），超过这个时长还没有可用的连接，则会抛出SQLException
      minimum-idle: 5                         # 最小连接数
      maximum-pool-size: 20                   # 最大连接数
      auto-commit: true                       # 自动提交
      idle-timeout: 600000                    # 连接超时的最大时长（毫秒），超时则会被释放（retired）
      max-lifetime: 18000000                  # 连接池的最大生命时长（毫秒），超时则会被释放（retired）
      connection-test-query: SELECT 1
      
      
# MyBatisPlus 的配置
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      id-type: assign_id
      update-strategy: not_empty
  mapper-locations: classpath*:/mappers/*.xml
```

Product.java
```
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
```


mapper.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.itzixi.mapper.ProductMapper">

    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="com.itzixi.entity.Product">
        <id column="product_id" property="productId" />
        <result column="product_name" property="productName" />
        <result column="brand" property="brand" />
        <result column="description" property="description" />
        <result column="price" property="price" />
        <result column="stock" property="stock" />
        <result column="status" property="status" />
        <result column="create_time" property="createTime" />
        <result column="update_time" property="updateTime" />
    </resultMap>

</mapper>
```

mapper.java
```
public interface ProductMapper extends BaseMapper<Product> {
}
```

Application.java 启动类添加：
`@MapperScan("com.itzixi.mapper")`