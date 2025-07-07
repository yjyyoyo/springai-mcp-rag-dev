# 云服务器配置安装OpenJDK21

https://jdk.java.net/archive/

```
# 配置java环境变量
export JAVA_HOME=/usr/java/jdk-21
export CLASSPATH=.:%JAVA_HOME%/lib/dt.jar:%JAVA_HOME%/lib/tools.jar
export PATH=$PATH:$JAVA_HOME/bin
```
