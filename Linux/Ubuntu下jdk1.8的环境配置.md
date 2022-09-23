# 在Ubuntu下配置jdk1.8的环境

## 使用apt命令安装JRE

### 安装Oracle jdk8

```csharp
sudo apt-get install oracle-java8-installer
```

安装器会提示你同意 oracle 的服务条款,选择 ok.

### 安装OpenJDK

ubuntu安装Java的最简单方法是使用与Ubuntu一起打包的版本。默认情况下，[Ubuntu](https://links.jianshu.com/go?to=https%3A%2F%2Fwww.centos.bz%2Ftag%2Fubuntu%2F) 18.04包含Open JDK，它是JRE和JDK的开源版本。



```dart
java -version

Command 'java' not found, but can be installed with:

apt install default-jre
apt install openjdk-11-jre-headless
apt install openjdk-8-jre-headless
```

直接根据提示选择对应版本



```css
apt install openjdk-8-jre-headless
java -version
openjdk version "1.8.0_242"
OpenJDK Runtime Environment (build 1.8.0_242-8u242-b08-0ubuntu3~18.04-b08)
OpenJDK 64-Bit Server VM (build 25.242-b08, mixed mode)
```



作者：工木南ng
链接：https://www.jianshu.com/p/9fb4c271fa96
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## 手动安装

### 到Oracle官网下载JDK1.8

### 解压到对应文件夹中

创建目录:

```shell
sudo mkdir /usr/lib/jvm
```

解压缩到该目录:

```
sudo tar -zxvf jdk-14.0.1_linux-x64_bin.tar.gz -C /usr/lib/jvm
```

### 添加环境变量

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

### 系统注册JDk
```shell
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-14.0.1/bin/java 300
```

### 检验是否安装成功
```shell
java -version
```
