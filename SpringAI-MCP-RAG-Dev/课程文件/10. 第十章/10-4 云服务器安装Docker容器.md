# 10-4 安装Docker容器

### 卸载老版本docker

```
sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine
```


### 设置docker库（地址）
```
sudo yum install -y yum-utils
```


配置docker的地址，也就是指定repo所在地：

```
sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
```


### 安装docker
安装docker引擎，docker客户端，docker容器：
```
sudo yum install docker-ce docker-ce-cli containerd.io
```

如此，安装完毕。

### 启动docker
启动docker服务：
```
sudo systemctl start docker
```

查看docker版本号：
```
docker -v
```


### 设置docker开机自启动

```
systemctl enable docker
```

随后可以重启linux测试是否开启自启动。

重启docker
```
sudo systemctl restart docker
```
