<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<div style="text-align: center">
    <%--这里表单表示的意思，以post方式提交表单，提交到我们的login请求    --%>
    <form action="/req/login" method="post">
        用户名：<input type="text" name="username"> <br>
        密码：<input type="password" name="password"> <br>
        爱好：
        <input type="checkbox" name="hobbies" value="代码">代码
        <input type="checkbox" name="hobbies" value="电影">电影
        <input type="checkbox" name="hobbies" value="跑步">跑步
        <br>
        <input type="submit">

    </form>
</div>
</body>
</html>