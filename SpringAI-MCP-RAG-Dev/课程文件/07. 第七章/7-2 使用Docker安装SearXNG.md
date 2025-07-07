# 使用Docker安装SearXNG

```
docker pull searxng/searxng:latest
```

```
docker run -p 6080:8080 \
        --name searxng \
        -d --restart=always \
        -v "/Volumes/lee/docker/SearXNG:/etc/searxng" \
        -e "BASE_URL=http://localhost:$PORT/" \
        -e "INSTANCE_NAME=lee-instance" \
        searxng/searxng
```

访问地址：
http://localhost:6080

api地址：
http://localhost:6080/search?q=风间影月&format=json