# 在Ubuntu下配置jdk1.8的环境

## 到Oracle官网下载JDK1.8

## 解压到对应文件夹中

创建目录:

```shell
sudo mkdir /usr/lib/jvm
```

解压缩到该目录:

```
sudo tar -zxvf jdk-14.0.1_linux-x64_bin.tar.gz -C /usr/lib/jvm
```

## 添加环境变量

```shell
sudo vi ~/.bashrc
```

在文件末尾追加下面内容：
```shell
#set oracle jdk environment
export JAVA_HOME=/usr/lib/jvm/jdk-14.0.1 ## 这里要注意目录要换成自己解压的jdk 目录
export JRE_HOME=${JAVA_HOME}/jre  
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib  
export PATH=${JAVA_HOME}/bin:$PATH  
```
使环境变量马上生效：
```shell
source ~/.bashrc
```

## 系统注册JDk
```shell
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-14.0.1/bin/java 300
```

## 检验是否安装成功
```shell
java -version
```
