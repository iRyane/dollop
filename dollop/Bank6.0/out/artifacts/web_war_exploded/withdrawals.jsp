<%--
  Created by IntelliJ IDEA.
  User: Ryan
  Date: 2017/8/18
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="withdrawals.do" method="post">
    <spring:message code="page.withdrawals.amount"/> ：<input type="text" name="money">
    <input type="submit" value="<spring:message code="page.confirm"/> "><br>
    <a href="login.jsp"><spring:message code="page.back"/> </a>
</form>
${requestScope.inputmessage}
</body>
</html>
