<%--设置响应类型和编码规则--%>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<body>
    <%--将三个页面合为一个页面    --%>
    <%@include file="common/header.jsp" %>
    <h1>网页主体</h1>
    <%@include file="common/footer.jsp" %>

    <hr>
    <%--拼接页面，实际上还是一个页面--%>
    <jsp:include page="/common/header.jsp"/>
    <h1>网页主体</h1>
    <jsp:include page="/common/footer.jsp"/>

</body>
</html>
