<%--
  Created by IntelliJ IDEA.
  User: Ryan
  Date: 2017/8/18
  Time: 22:40
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
<form action="register.do" >
    <spring:message code="page.input.username"/> ：<input type="text" name="name"><br>
    <spring:message code="page.input.password"/> ：<input type="password" name="password"><br>
    <spring:message code="page.confirm.password"/> ：<input type="password" name="repass"><br>
    <input type="submit" value="<spring:message code="page.confirm"/> ">
    <a href="index.jsp"><spring:message code="page.back"/> </a>
    <p style="color: red;font-size: 16px;">${requestScope.message}</p>
</form>
</body>
</html>
