##  初识JavaWeb

### Web及Web服务器

- **万维网**（英语：World Wide Web）亦作**WWW**、**Web**、**全球广域网**，是一个透过[互联网](https://zh.m.wikipedia.org/wiki/互联网)访问的，由许多互相链接的[超文本](https://zh.m.wikipedia.org/wiki/超文本)组成的[信息系统](https://zh.m.wikipedia.org/wiki/信息系统)

- **网页服务器**（英语：Web server）一词有两个意思：

1. 一台负责提供网页的[电脑](https://zh.m.wikipedia.org/wiki/電腦)，主要是各种编程语言构建而成，通过[超文本传输协议](https://zh.m.wikipedia.org/wiki/超文本传输协议)（英语：HTTP）传给客户端（一般是指[网页浏览器](https://zh.m.wikipedia.org/wiki/網頁瀏覽器)）。

2. 一个提供网页的服务器程序。

   每一台网页服务器（第1个意思）会执行最少一个网页服务器程序（第2个意思）。此外，也通称作**Web服务器**。

### HTTP

**超文本传输协议**（英语：**H**yper**T**ext **T**ransfer **P**rotocol，缩写：**HTTP**）是一种用于分布式、协作式和[超媒体](https://zh.m.wikipedia.org/wiki/超媒體)信息系统的[应用层](https://zh.m.wikipedia.org/wiki/应用层)[协议](https://zh.m.wikipedia.org/wiki/网络传输协议)[[1\]](https://zh.m.wikipedia.org/wiki/超文本传输协议#cite_note-ietf2616-1)。HTTP是[万维网](https://zh.m.wikipedia.org/wiki/全球資訊網)的数据通信的基础。

设计HTTP最初的目的是为了提供一种发布和接收[HTML](https://zh.m.wikipedia.org/wiki/HTML)页面的方法。通过HTTP或者[HTTPS](https://zh.m.wikipedia.org/wiki/HTTPS)协议请求的资源由[统一资源标识符](https://zh.m.wikipedia.org/wiki/统一资源标志符)（Uniform Resource Identifiers，URI）来标识。

- **协议概述**

HTTP是一个客户端（用户）和服务端（网站）之间请求和应答的标准，通常使用[TCP协议](https://zh.m.wikipedia.org/wiki/传输控制协议)。通过使用[网页浏览器](https://zh.m.wikipedia.org/wiki/網頁瀏覽器)、[网络爬虫](https://zh.m.wikipedia.org/wiki/网络爬虫)或者其它的工具，客户端发起一个HTTP请求到服务器上指定端口（默认[端口](https://zh.m.wikipedia.org/wiki/通訊埠)为80）。我们称这个客户端为用户代理程序（user agent）。应答的服务器上存储着一些资源，比如HTML文件和图像。我们称这个应答服务器为源服务器（origin server）。在用户代理和源服务器中间可能存在多个“中间层”，比如[代理服务器](https://zh.m.wikipedia.org/wiki/代理伺服器)、[网关](https://zh.m.wikipedia.org/wiki/网关)或者[隧道](https://zh.m.wikipedia.org/wiki/隧道)（tunnel）。

尽管[TCP/IP](https://zh.m.wikipedia.org/wiki/TCP/IP)协议是互联网上最流行的应用，但是在HTTP协议中并没有规定它必须使用或它支持的层。事实上HTTP可以在任何互联网协议或其他网络上实现。HTTP假定其下层协议提供可靠的传输。因此，任何能够提供这种保证的协议都可以被其使用，所以其在TCP/IP协议族使用TCP作为其传输层。

通常，由HTTP客户端发起一个请求，创建一个到服务器指定端口（默认是80端口）的TCP连接。HTTP服务器则在那个端口监听客户端的请求。一旦收到请求，服务器会向客户端返回一个状态，比如"HTTP/1.1 200 OK"，以及返回的内容，如请求的文件、错误消息、或者其它信息。

- **请求方法**

  根据 HTTP 标准，HTTP 请求可以使用多种请求方法。

  HTTP1.0 定义了三种请求方法： GET, POST 和 HEAD 方法。

  HTTP1.1 新增了六种请求方法：OPTIONS、PUT、PATCH、DELETE、TRACE 和 CONNECT 方法。

  | 序号 | 方法    | 描述                                                         |
  | :--- | :------ | :----------------------------------------------------------- |
  | 1    | GET     | 请求指定的页面信息，并返回实体主体。                         |
  | 2    | HEAD    | 类似于 GET 请求，只不过返回的响应中没有具体的内容，用于获取报头 |
  | 3    | POST    | 向指定资源提交数据进行处理请求（例如提交表单或者上传文件）。数据被包含在请求体中。POST 请求可能会导致新的资源的建立和/或已有资源的修改。 |
  | 4    | PUT     | 从客户端向服务器传送的数据取代指定的文档的内容。             |
  | 5    | DELETE  | 请求服务器删除指定的页面。                                   |
  | 6    | CONNECT | HTTP/1.1 协议中预留给能够将连接改为管道方式的代理服务器。    |
  | 7    | OPTIONS | 允许客户端查看服务器的性能。                                 |
  | 8    | TRACE   | 回显服务器收到的请求，主要用于测试或诊断。                   |
  | 9    | PATCH   | 是对 PUT 方法的补充，用来对已知资源进行局部更新 。           |

- **版本**

  ![查看源图像](2019120710092218.png)

   **HTTP/3**

  ### 最新版本，于2022年6月6日标准化为RFC9114。会抛弃使用TCP，通过UDP上使用QUIC来承载应用层数据。

- **状态码**

  所有HTTP响应的第一行都是**状态行**，依次是当前HTTP版本号，3位数字组成的[状态代码](https://zh.m.wikipedia.org/wiki/HTTP状态码)，以及描述状态的短语，彼此由空格分隔。

  状态代码的第一个数字代表当前响应的类型：

  - [1xx消息](https://zh.m.wikipedia.org/wiki/HTTP状态码#1xx消息)——请求已被服务器接收，继续处理
  - [2xx成功](https://zh.m.wikipedia.org/wiki/HTTP状态码#2xx成功)——请求已成功被服务器接收、理解、并接受
  - [3xx重定向](https://zh.m.wikipedia.org/wiki/HTTP状态码#3xx重定向)——需要后续操作才能完成这一请求
  - [4xx请求错误](https://zh.m.wikipedia.org/wiki/HTTP状态码#4xx请求错误)——请求含有词法错误或者无法被执行
  - [5xx服务器错误](https://zh.m.wikipedia.org/wiki/HTTP状态码#5xx服务器错误)——服务器在处理某个正确请求时发生错误

- **协议例子**

   

- **持久连接**

  **HTTP持久连接**（英语：**HTTP persistent connection**，也称作**HTTP keep-alive**或**HTTP connection reuse**）是使用同一个[TCP](https://zh.m.wikipedia.org/wiki/传输控制协议)连接来发送和接收多个HTTP请求/应答，而不是为每一个新的请求/应答打开新的连接的方法。

- **无状态**

  HTTP无状态协议，是指协议对于事务处理没有记忆[能力](https://baike.baidu.com/item/能力/33045?fromModule=lemma_inlink)。缺少状态意味着如果后续处理需要前面的信息，则它必须重传，这样可能导致每次连接传送的数据量增大。另一方面，在服务器不需要先前信息时它的应答就较快。

  客户端与服务器进行动态交互的Web应用程序出现之后，HTTP无状态的特性严重阻碍了这些应用程序的实现，毕竟交互是需要承前启后的，简单的购物车程序也要知道用户到底在之前选择了什么商品。于是，两种用于保持HTTP连接状态的技术就应运而生了，一个是[Cookie](https://baike.baidu.com/item/Cookie?fromModule=lemma_inlink)，而另一个则是[Session](https://baike.baidu.com/item/Session?fromModule=lemma_inlink)。HTTP本身是一个无状态的[连接协议](https://baike.baidu.com/item/连接协议?fromModule=lemma_inlink)，为了支持客户端与服务器之间的交互，我们就需要通过不同的技术为交互存储状态，而这些不同的技术就是Cookie和Session了。

  - **Cookie**

    Cookie是通过客户端保持状态的[解决](https://baike.baidu.com/item/解决/32786?fromModule=lemma_inlink)方案。从定义上来说，Cookie就是由服务器发给客户端的特殊信息，而这些信息以文本文件的方式存放在客户端，然后客户端每次向服务器发送请求的时候都会带上这些特殊的信息。让我们说得更具体一些：当用户使用浏览器访问一个支持[Cookie](https://baike.baidu.com/item/Cookie/1119?fromModule=lemma_inlink)的网站的时候，用户会提供包括用户名在内的个人信息并且提交至服务器；接着，服务器在向客户端回传相应的[超文本](https://baike.baidu.com/item/超文本?fromModule=lemma_inlink)的同时也会发回这些个人信息，当然这些信息并不是存放在HTTP响应体（Response Body）中的，而是存放于HTTP响应头（Response Header）；当客户端浏览器接收到来自服务器的响应之后，浏览器会将这些信息存放在一个统一的位置，对于[Windows操作系统](https://baike.baidu.com/item/Windows操作系统/852149?fromModule=lemma_inlink)而言，我们可以从： [[系统盘](https://baike.baidu.com/item/系统盘?fromModule=lemma_inlink)]:\Documents and Settings\[用户名]\Cookies目录中找到存储的Cookie；自此，客户端再向服务器发送请求的时候，都会把相应的[Cookie](https://baike.baidu.com/item/Cookie/1119?fromModule=lemma_inlink)再次发回至服务器。而这次，Cookie信息则存放在[HTTP请求头](https://baike.baidu.com/item/HTTP请求头/6623287?fromModule=lemma_inlink)（Request Header）了

    有了Cookie这样的技术实现，服务器在接收到来自客户端浏览器的请求之后，就能够通过分析存放于请求头的Cookie得到客户端特有的信息，从而动态生成与该客户端相对应的内容。通常，我们可以从很多网站的登录界面中看到“请记住我”这样的选项，如果你勾选了它之后再登录，那么在下一次访问该网站的时候就不需要进行重复而繁琐的登录动作了，而这个功能就是通过Cookie实现的。

    [Windows 10 中所有主流浏览器的 cookie 存储在哪里？](https://gaopc.cn/130621.html)

  - **Session**

    与Cookie相对的一个解决方案是Session，它是通过服务器来保持状态的。由于[Session](https://baike.baidu.com/item/Session/479100?fromModule=lemma_inlink)这个词汇包含的语义很多，因此需要在这里明确一下 Session的含义。首先，我们通常都会把Session翻译成会话，因此我们可以把客户端浏览器与服务器之间一系列交互的动作称为一个 Session。从这个语义出发，我们会提到Session持续的时间，会提到在Session过程中进行了什么操作等等；其次，Session指的是服务器端为客户端所开辟的存储空间，在其中保存的信息就是用于保持状态。从这个语义出发，我们则会提到往Session中存放什么内容，如何根据键值从 Session中获取匹配的内容等。

    要使用Session，第一步当然是创建Session了。那么Session在何时创建呢？当然还是在服务器端程序运行的过程中创建的，不同语言实现的应用程序有不同创建Session的方法，而在[Java](https://baike.baidu.com/item/Java/85979?fromModule=lemma_inlink)中是通过调用HttpServletRequest的getSession方法（使用true作为参数）创建的。在创建了[Session](https://baike.baidu.com/item/Session/479100?fromModule=lemma_inlink)的同时，服务器会为该Session生成唯一的Session id，而这个Session id在随后的请求中会被用来重新获得已经创建的Session；在Session被创建之后，就可以调用Session相关的方法往Session中增加内容了，而这些内容只会保存在服务器中，发到客户端的只有Session id；当客户端再次发送请求的时候，会将这个Session id带上，服务器接受到请求之后就会依据Session id找到相应的Session，从而再次使用之。正是这样一个过程，用户的状态也就得以保持了。

    综上所述，HTTP本身是一个无状态的[连接协议](https://baike.baidu.com/item/连接协议/7768217?fromModule=lemma_inlink)，为了支持客户端与服务器之间的交互，我们就需要通过不同的技术为交互存储状态，而这些不同的技术就是[Cookie](https://baike.baidu.com/item/Cookie/1119?fromModule=lemma_inlink)和Session了。

- **长连接**

  **HTTP的长连接和短连接本质上是TCP长连接和短连接**。HTTP属于应用层协议，在传输层使用TCP协议，在网络层使用IP协议。IP协议主要解决网络路由和寻址问题，TCP协议主要解决如何在IP层之上可靠的传递数据包，使在网络上的另一端收到发端发出的所有包，并且顺序与发出顺序一致。TCP有可靠，面向连接的特点。

  **在HTTP/1.0中，默认使用的是短连接**。也就是说，浏览器和服务器每进行一次HTTP操作，就建立一次连接，但任务结束就中断连接。如果客户端浏览器访问的某个HTML或其他类型的 Web页中包含有其他的Web资源，如JavaScript文件、图像文件、CSS文件等；当浏览器每遇到这样一个Web资源，就会建立一个HTTP会话。

  但从 **HTTP/1.1起，默认使用长连接**，用以保持连接特性。使用长连接的HTTP协议，会在响应头有加入这行代码：

  ```
  Connection:keep-alive
  ```

  在使用长连接的情况下，当一个网页打开完成后，客户端和服务器之间用于传输HTTP数据的 TCP连接不会关闭，如果客户端再次访问这个服务器上的网页，会继续使用这一条已经建立的连接。Keep-Alive不会永久保持连接，它有一个保持时间，可以在不同的服务器软件（如Apache）中设定这个时间。实现长连接要客户端和服务端都支持长连接。
  短连接的操作步骤是：
  建立连接——数据传输——关闭连接...建立连接——数据传输——关闭连接
  长连接的操作步骤是：
  建立连接——数据传输...（保持连接）...数据传输——关闭连接

 　**长连接**多用于操作频繁，点对点的通讯，而且连接数不能太多情况，。每个TCP连接都需要三步握手，这需要时间，如果每个操作都是先连接，再操作的话那么处理速度会降低很多，所以每个操作完后都不断开，次处理时直接发送数据包就OK了，不用建立TCP连接。例如：数据库的连接用长连接， 如果用短连接频繁的通信会造成socket错误，而且频繁的socket 创建也是对资源的浪费。 

　　而像WEB网站的http服务一般都用**短链接**，因为长连接对于服务端来说会耗费一定的资源，而像WEB网站这么频繁的成千上万甚至上亿客户端的连接用短连接会更省一些资源，如果用长连接，而且同时有成千上万的用户，如果每个用户都占用一个连接的话，那可想而知吧。所以并发量大，每个用户在无需频繁操作情况下需用短连好。


### Tomcat

### Maven

## Servlet

### ServletContext

### Response

### Request

### Cookie

### Session

## JSP

### JSP原理

### JSP基础语法

### JSP内置对象

### JSTL标签

### JavaBean

## MVC

## JDBC