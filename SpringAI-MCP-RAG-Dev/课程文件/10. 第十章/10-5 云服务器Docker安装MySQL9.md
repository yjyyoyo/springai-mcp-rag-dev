# Docker安装MySQL9

### 下载MySQL9
```
docker pull mysql:9.3.0
```
下载完毕，检查镜像：
```
docker images
```

### 运行MySQL9

创建目录
```
mkdir /home/docker/mysql9/log -p
mkdir /home/docker/mysql9/data -p
mkdir /home/docker/mysql9/conf -p
mkdir /home/docker/mysql9/mysql-files -p
```

使用如下命令来启动mysql容器：
```
docker run -p 5506:3306 --name mysql9-imooc \
-v /home/docker/mysql9/log:/var/log/mysql \
-v /home/docker/mysql9/data:/var/lib/mysql \
-v /home/docker/mysql9/conf:/etc/mysql/conf.d \
-v /home/docker/mysql9/mysql-files:/var/lib/mysql-files \
-e MYSQL_ROOT_PASSWORD=fengjianyingyue \
-d mysql:9.3.0 \
--character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```

其他命令：
```
docker start mysql
docker stop mysql
docker restart mysql
```