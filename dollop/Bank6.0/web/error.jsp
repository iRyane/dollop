<%--
  Created by IntelliJ IDEA.
  User: Ryan
  Date: 2017/8/18
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>error</title>
</head>
<body>
${requestScope.message}
<%
    response.setHeader("refresh","3;URL=login.jsp");
%>
<p style="color: red;"><spring:message code="page.message1"/> <a href="login.jsp"><spring:message code="page.here"/> </a>
</p>
</body>
</html>
