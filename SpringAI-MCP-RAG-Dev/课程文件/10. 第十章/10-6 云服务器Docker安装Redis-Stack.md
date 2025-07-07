# 使用Docker安装Redis作为向量库

```
docker pull redis/redis-stack:latest
```

```
docker run -d --name redis-stack \
-p 9379:6379 \
-e REDIS_ARGS="--requirepass fengjianyingyue" \
redis/redis-stack:latest
```

```
docker-compose up -d
```