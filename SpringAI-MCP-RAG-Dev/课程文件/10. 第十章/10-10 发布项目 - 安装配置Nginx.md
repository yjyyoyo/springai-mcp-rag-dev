# 发布项目 - 安装配置Nginx

1. 去官网( http://nginx.org/ )下载对应的nginx包，推荐使用稳定版本

2. 上传ngxin到linux系统

3. 安装依赖环境
    1. 安装gcc环境
        * yum install gcc-c++
    2. 安装PCRE库，用于解析正则表达式
        * yum install -y pcre pcre-devel
    3. zlib压缩和解压缩依赖，
        * yum install -y zlib zlib-devel
    4. SSL 安全的加密的套接字协议层，用于HTTP安全传输，也就是https
        * yum install -y openssl openssl-devel

4. 解压，需要注意，解压后得到的是源码，源码需要编译后才能安装
    ```
    tar -zxvf nginx-1.16.1.tar.gz
    ```
5. 编译之前，先创建nginx临时目录，如果不创建，在启动nginx的过程中会报错
    ```
    mkdir /var/temp/nginx -p
    ```
3. 在nginx目录，输入如下命令进行配置，目的是为了创建makefile文件
    ```
    ./configure \
    --prefix=/usr/local/nginx \
    --pid-path=/var/run/nginx/nginx.pid \
    --lock-path=/var/lock/nginx.lock \
    --error-log-path=/var/log/nginx/error.log \
    --http-log-path=/var/log/nginx/access.log \
    --with-http_gzip_static_module \
    --http-client-body-temp-path=/var/temp/nginx/client \
    --http-proxy-temp-path=/var/temp/nginx/proxy \
    --http-fastcgi-temp-path=/var/temp/nginx/fastcgi \
    --http-uwsgi-temp-path=/var/temp/nginx/uwsgi \
    --http-scgi-temp-path=/var/temp/nginx/scgi \
    --with-http_stub_status_module --with-http_ssl_module
    ```

    * *注：\ 代表在命令行中换行，用于提高可读性*
    * 配置命令：

      | 命令 | 解释 |
              | --- | --- |
      | --prefix | 指定nginx安装目录 |
      | --pid-path | 指向nginx的pid |
      | --lock-path | 锁定安装文件，防止被恶意篡改或误操作 |
      | --error-log | 错误日志 |
      | --http-log-path | http日志 |
      | --with-http_gzip_static_module | 启用gzip模块，在线实时压缩输出数据流 |
      | --http-client-body-temp-path | 设定客户端请求的临时目录 |
      | --http-proxy-temp-path | 设定http代理临时目录 |
      | --http-fastcgi-temp-path | 设定fastcgi临时目录 |
      | --http-uwsgi-temp-path | 设定uwsgi临时目录 |
      | --http-scgi-temp-path | 设定scgi临时目录 |=/var/temp/nginx/scgi |


1. make编译
    ```
    make
    ```
2. 安装
    ```
    make install
    ```
3. 进入sbin目录启动nginx
    ```
    ./nginx
    ```
    * 停止：./nginx -s stop
    * 重新加载：./nginx -s reload

4. 打开浏览器，访问虚拟机所处内网ip即可打开nginx默认页面。


    