# 使用Docker安装SearXNG

```
docker pull searxng/searxng:latest
```

```
mkdir /home/docker/SearXNG -p
```

```
docker run -p 6080:8080 \
        --name searxng \
        -d --restart=always \
        -v "/home/docker/SearXNG:/etc/searxng" \
        -e "BASE_URL=http://localhost:$PORT/" \
        -e "INSTANCE_NAME=lee-instance" \
        searxng/searxng
```

访问地址：
http://101.32.223.87:6080

api地址：
http://101.32.223.87:6080/search?q=风间影月&format=json