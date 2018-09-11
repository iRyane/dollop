<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
    <title>Welcome</title>
  </head>
  <body>
  	<form action="login.do" method="post">
     <spring:message code="label.username"/> <input type="text" name="name"><br>
     <spring:message code="label.password"/> <input type="password" name="password">
        <a href="register.jsp"><spring:message code="url.register"/> </a><br>
		<input type="submit" value="<spring:message code="btn.login"/> ">
  	</form>
    <h3><p style="color: red;">${message}</p></h3>
  <a href="/changelanguage.do?lan=zh"><spring:message code="url.chinese"/> </a>
    <a href="/changelanguage.do?lan=en"><spring:message code="url.english"/> </a>
  </body>
</html>