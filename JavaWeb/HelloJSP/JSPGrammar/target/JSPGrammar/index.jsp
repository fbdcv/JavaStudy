<%--设置响应类型和编码规则--%>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<body>

    <%@include file="common/header.jsp" %>
    <h1>网页主体</h1>
    <%@include file="common/footer.jsp" %>

    <hr>

    <jsp:include page="/common/header.jsp"/>
    <h1>网页主体</h1>
    <jsp:include page="/common/footer.jsp"/>

</body>
</html>
