<%--
  Created by IntelliJ IDEA.
  User: Ryan
  Date: 2017/8/18
  Time: 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="button" onclick="window.location.href='deposit.jsp'" value="<spring:message code="btn.deposit"/> "><br>
    <input type="button" onclick="window.location.href='withdrawals.jsp'" value="<spring:message code="btn.withdrawals"/> "><br>
    <input type="button" onclick="window.location.href='transfer.jsp'" value="<spring:message code="btn.transfer"/> "><br>
    <form action="inquiry.do" method="post">
        <input type="submit" value="<spring:message code="btn.inquiry"/> ">
    </form>
    <input type="button" onclick="window.location.href='index.do'" value="<spring:message code="btn.exit"/> "><br>
</body>
</html>
