<%--
  Created by IntelliJ IDEA.
  User: Ryan
  Date: 2017/8/18
  Time: 0:36
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
<form action="transfer.do" method="post">
    <spring:message code="page.transfer.account"/> ：<input type="text" name="inAccount"><br>
    <spring:message code="page.transfer.amount"/> ：<input type="text" name="money">
    <a href="login.jsp"><spring:message code="page.back"/> </a><br>
    <input type="submit" value="<spring:message code="page.confirm"/> ">
</form>
    ${requestScope.inputmessage}
</body>
</html>
