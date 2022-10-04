<%--
  Created by IntelliJ IDEA.
  User: wz
  Date: 2022/10/1
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--启用EL表达式--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("name1","FBDCV1");
        request.setAttribute("name2","FBDCV2");
        session.setAttribute("name3","FBDCV3");
        application.setAttribute("name4","FBDCV4");
//        pageContext.forward("/jsp2.jsp");
        String name1 = (String) pageContext.findAttribute("name1");
        String name2 = (String) pageContext.findAttribute("name2");
        String name3 = (String) pageContext.findAttribute("name3");
        String name4 = (String) pageContext.findAttribute("name4");
        String name5 = (String) pageContext.findAttribute("name5");    //属性name5是不存在的
    %>

    <h1>${name1}</h1>
    <h1>${name2}</h1>
    <h1>${name3}</h1>
    <h1>${name4}</h1>
    <h1>${name5}</h1>


</body>
</html>
