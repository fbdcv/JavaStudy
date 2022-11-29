# 初识Spring

## Spring 历史

时间回到2002年，当时正是 Java EE 和 EJB 大行其道的时候，很多知名公司都是采用此技术方案进行项目开发。这时候有一个美国的小伙子认为 EJB 太过臃肿，并不是所有的项目都需要使用 EJB 这种大型[框架](https://so.csdn.net/so/search?q=框架&spm=1001.2101.3001.7020)，应该会有一种更好的方案来解决这个问题。

为了证明他的想法是正确的，于2002年10月甚至写了一本书《 Expert One-on-One J2EE 》，介绍了当时 Java 企业应用程序开发的情况，并指出了 Java EE 和 EJB 组件框架中存在的一些主要缺陷。在这本书中，他提出了一个基于普通 Java 类和依赖注入的更简单的解决方案。

在书中，他展示了如何在不使用 EJB 的情况下构建高质量，可扩展的在线座位预留系统。为了构建应用程序，他编写了超过 30,000 行的基础结构代码，项目中的根包命名为 com.interface21，所以人们最初称这套开源框架为 **interface21**，也就是 Spring 的前身。

他是谁呢，他就是大名鼎鼎的 **Rod Johnson** （下图）, Rod Johnson 在悉尼大学不仅获得了计算机学位，同时还获得了音乐学位，更令人吃惊的是在回到软件开发领域之前，他还获得了音乐学的博士学位。现在 Rod Johnson 已经离开了 Spring ，成为了一个天使投资人，同时也是多个公司的董事，早已走上人生巅峰。

![img](20190606144142581.jpg)

在这本书发布后，一对一的 J2EE 设计和开发一炮而红。这本书免费提供的大部分基础架构代码都是高度可重用的。 2003 年 Rod Johnson 和同伴在此框架的基础上开发了一个全新的框架命名为 Spring ,据 Rod Johnson 介绍 Spring 是传统 J2EE 新的开始。随后 Spring 发展进入快车道。

2004 年 03 月，1.0 版发布。

2006 年 10 月，2.0 版发布。

2007 年 11 月更名为 SpringSource，同时发布了 Spring 2.5。

2009 年 12 月，Spring 3.0 发布。

2013 年 12 月，Pivotal 宣布发布 Spring 框架 4.0。

2017 年 09 月，Spring 5.0 发布。

## Spring模块

**Spring框架**是 [Java](https://zh.wikipedia.org/wiki/Java) 平台的一个[开源](https://zh.wikipedia.org/wiki/开放源代码)的全栈（[full-stack](https://zh.wikipedia.org/wiki/全栈)）[应用程序框架](https://zh.wikipedia.org/wiki/软件框架)和[控制反转](https://zh.wikipedia.org/wiki/控制反转)容器实现，一般被直接称为 Spring。

**总结一句话：Spring就是一个轻量级的控制反转（IOC）和面向切面编程（AOP）的框架**

该框架的一些核心功能理论上可用于任何 Java 应用，但 Spring 还为基于[Java企业版](https://zh.wikipedia.org/wiki/Jakarta_EE)平台构建的 Web 应用提供了大量的拓展支持

![1. Introduction to Spring Framework](spring-overview.png)

## Spring全家桶

随着使用 Spring 进行开发的个人和企业越来越多，Spring 也慢慢从一个单一简洁的小框架变成一个大而全的开源软件，Spring 的边界不断的进行扩充，到了后来 Spring 几乎可以做任何事情了，市面上主流的开源软件、中间件都有 Spring 对应组件支持，人们在享用 Spring 的这种便利之后，也遇到了一些问题。

Spring 每集成一个开源软件，就需要增加一些基础配置，慢慢的随着人们开发的项目越来越庞大，往往需要集成很多开源软件，因此后期使用 Spirng 开发大型项目需要引入很多配置文件，太多的配置非常难以理解，并容易配置出错，到了后来人们甚至称 Spring 为**配置地狱**。

Spring 似乎也意识到了这些问题，急需有这么一套软件可以解决这些问题，这个时候微服务的概念也慢慢兴起，快速开发微小独立的应用变得更为急迫，Spring 刚好处在这么一个交叉点上，于 2013 年初开始的 Spring Boot 项目的研发，2014年4月，Spring Boot 1.0.0 发布。

![Das Spring-Framework soll die Komplexität der Java-Plattform deutlich reduzieren, um die Entwicklung übersichtlicher und effizienter zu gestalten](original.jpg)

Spring 最初最核心的两大核心功能 Spring Ioc 和 Spring Aop 成就了 Spring，Spring 在这两大核心的功能上不断的发展，才有了 Spring 事务、Spirng Mvc 等一系列伟大的产品，最终成就了 Spring 帝国，到了后期 Spring 几乎可以解决企业开发中的所有问题。

Spring Boot 是在强大的 Spring 帝国生态基础上面发展而来，发明 Spring Boot 不是为了取代 Spring ,是为了让人们更容易的使用 Spring 。所以说没有 Spring 强大的功能和生态，就不会有后期的 Spring Boot 火热, Spring Boot 使用约定优于配置的理念，重新重构了 Spring 的使用，让 Spring 后续的发展更有生命力。

Spring Cloud 是一系列框架的有序集合。它利用 Spring Boot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 Spring Boot 的开发风格做到一键启动和部署。

Spring 并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过 Spring Boot 风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。

根据上面的说明我们可以看出来，Spring Cloud 是为了解决微服务架构中服务治理而提供的一系列功能的开发框架，并且 Spring Cloud 是完全基于 Spring Boot 而开发，Spring Cloud 利用 Spring Boot 特性整合了开源行业中优秀的组件，整体对外提供了一套在微服务架构中服务治理的解决方案。

综上我们可以这样来理解，正是由于 Spring Ioc 和 Spring Aop 两个强大的功能才有了 Spring ，Spring 生态不断的发展才有了 Spring Boot ，使用 Spring Boot 让 Spring 更易用更有生命力，Spring Cloud 是基于 Spring Boot 开发的一套微服务架构下的服务治理方案。

用一组不太合理的包含关系来表达它们之间的关系。

```
 Spring ioc/aop > Spring > Spring Boot > Spring Cloud 
```



# IOC控制反转

**控制反转**（Inversion of Control，缩写为**IoC**），是[面向对象编程](https://baike.baidu.com/item/面向对象编程/254878?fromModule=lemma_inlink)中的一种设计原则，可以用来减低计算机[代码](https://baike.baidu.com/item/代码/86048?fromModule=lemma_inlink)之间的[耦合度](https://baike.baidu.com/item/耦合度/2603938?fromModule=lemma_inlink)。

其中最常见的方式叫做**[依赖注入](https://baike.baidu.com/item/依赖注入/5177233?fromModule=lemma_inlink)**（Dependency Injection，简称**DI**），还有一种方式叫**依赖查找**（Dependency Lookup）。

通过控制反转，对象在被创建的时候，由一个调控系统内所有对象的外界实体将其所依赖的对象的引用传递给它。也可以说，依赖被注入到对象中。

## IOC本质

IoC可以认为是一种全新的**设计模式**，但是理论和时间成熟相对较晚，并没有包含在[GoF](https://baike.baidu.com/item/GoF?fromModule=lemma_inlink)中。

Interface Driven Design接口驱动，接口驱动有很多好处，可以提供不同灵活的子类实现，增加代码稳定和健壮性等等，但是接口一定是需要实现的，也就是如下语句迟早要执行：AInterface a = new AInterfaceImp(); 这样一来，耦合关系就产生了，如：

```java
classA
{
    AInterface a;
 
    A(){}
     
    AMethod()//一个方法
    {
        a = new AInterfaceImp();
    }
}
```

Class A与AInterfaceImp就是依赖关系，如果想使用AInterface的另外一个实现就需要更改代码了。当然我们可以建立一个Factory来根据条件生成想要的AInterface的具体实现，即：

```java
InterfaceImplFactory
{
   AInterface create(Object condition)
   {
      if(condition == condA)
      {
          return new AInterfaceImpA();
      }
      else if(condition == condB)
      {
          return new AInterfaceImpB();
      }
      else
      {
          return new AInterfaceImp();
      }
    }
}
```

表面上是在一定程度上缓解了以上问题，但实质上这种代码耦合并没有改变。通过IoC模式可以彻底解决这种耦合，它把耦合从代码中移出去，放到统一的XML 文件中，通过一个容器在需要的时候把这个依赖关系形成，即把需要的接口实现注入到需要它的类中，这可能就是“依赖注入”说法的来源了。

IoC模式，系统中通过引入实现了IoC模式的IoC容器，即可由IoC容器来管理对象的生命周期、依赖关系等，从而使得应用程序的配置和依赖性规范与实际的应用程序代码分离。其中一个特点就是通过文本的配置文件进行应用程序组件间相互关系的配置，而不用重新修改并编译具体的代码。

可以把IoC模式看作工厂模式的升华，把IoC容器看作是一个大工厂，只不过这个大工厂里要生成的对象都是在XML文件中给出定义的。利用Java 的“反射”编程，根据XML中给出的类定义生成相应的对象。从实现来看，以前在工厂模式里写死了的对象，IoC模式改为配置XML文件，这就把工厂和要生成的对象两者隔离，极大提高了灵活性和可维护性。

IoC中最基本的Java技术就是“反射”编程。通俗的说，反射就是根据给出的类名（字符串）来生成对象。这种编程方式可以让应用在运行时才动态决定生成哪一种对象。反射的应用是很广泛的，像Hibernate、Spring中都是用“反射”做为最基本的技术手段。

在过去，反射编程方式相对于正常的对象生成方式要慢10几倍，这也许也是当时为什么[反射技术](https://baike.baidu.com/item/反射技术?fromModule=lemma_inlink)没有普遍应用开来的原因。但经SUN改良优化后，反射方式生成对象和通常对象生成方式，速度已经相差不大了（但依然有一倍以上的差距）。



## Hello,Spring

**Demo1**

通过maven导入spring的依赖包

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.23</version>
</dependency>

```

创建实体类Hello.java

```java
package top.fbdcv.pojo;

public class Hello {
    private String str;

    public String getStr() {
        return str;
    }
	//必须要有set方法，以便注入
    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
```

配置元数据

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

<!--使用spring来创建对象，在spring中对象都称为bean-->
<!--hello为变量名，class为类名，下面的属性为变量的属性    -->
    <bean id="hello" class="top.fbdcv.pojo.Hello">
        <property name="str" value="Spring"/>
    </bean>
</beans>
```

实例化容器

```java
@Test
public void HelloTest(){
    //获取spring的上下文对象
    //ApplicationContext是ClassPathXmlApplicationContext的父级接口
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    Hello hello = (Hello) context.getBean("hello");
    System.out.println(hello);
}
```

![image-20221129204844208](image-20221129204844208.png)

**Demo2**

![image-20221129220011029](image-20221129220011029.png)

**UserDao.java**

```java
package top.fbdcv.dao;

public interface UserDao {
    void getUser();
}
```

**UserDaoImpl.java**

```java
package top.fbdcv.dao;

public class UserDaoImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("默认获取用户数据");
    }
}
```

**UserDaoMysqlImpl.java**

```java
package top.fbdcv.dao;

public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("mysql获取用户数据");
    }
}
```

**UserDaoOracleImpl.java**

```java
package top.fbdcv.dao;

public class UserDaoOracleImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("Oracle获取用户数据");
    }
}
```

**UserService.java**

```java
package top.fbdcv.service;

public interface UserService {
    void getUser();
}
```

**UserServiceImpl.java**

```java
package top.fbdcv.service;

import top.fbdcv.dao.UserDao;
import top.fbdcv.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
```

**beans.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="Impl" class="top.fbdcv.dao.UserDaoImpl"/>
    <bean id="mysqlImpl" class="top.fbdcv.dao.UserDaoMysqlImpl"/>
    <bean id="oracleImpl" class="top.fbdcv.dao.UserDaoOracleImpl"/>
    <bean id="userServiceImpl" class="top.fbdcv.service.UserServiceImpl">
        <!--
                ref：引用Spring容器中创建好的对象
                value：基本数据类型的值
        -->
        <property name="userDao" ref="mysqlImpl"/>
     </bean>

</beans>
```

进行测试

```java
@Test
public void UserServiceTest(){
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    UserServiceImpl userServiceImpl = (UserServiceImpl)context.getBean("userServiceImpl");
    userServiceImpl.getUser();
}
```

![image-20221129220455689](image-20221129220455689.png)

如果我们想更换dao层的操作，我们只需要修改spring的元数据文件即可

例如，dao层实现从mysql改为orcale

```xml
<bean id="userServiceImpl" class="top.fbdcv.service.UserServiceImpl">
    <property name="userDao" ref="oracleImpl"/>
 </bean>
```

![image-20221129222003666](image-20221129222003666.png)



让我们再理解一下控制反转和依赖注入

控制：控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用Spring后，对象是由Spring来创建的

反转：程序本身不创建对象，而是变成被动的接收对象

依赖注入：就是通过set方法进行注入

所谓的IOC，就是对象由Spring来创建，管理，装配



## IOC创建对象的方式

## Spring配置说明

## DI

## Bean

## 注解开发

## JavaConfig配置



# AOP

## 静态代理

## 动态代理

## AOP实现方式

## 注解实现AOP

# 整合Mybatis

# Spring事务

