<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Login Admin</title>
<!-- MAIN CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/<c:url value="assets"/>/customers/css/login.css">
</head>
<body>
	<div class="center">
      <h1>Login</h1>
      <form name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST'>
        <div class="txt_field">
          <input type="text" name="username" required>
          <span></span>
          <label>User Name</label>
        </div>
        <div class="txt_field">
          <input type="password" name="password" required>
          <span></span>
          <label>Password</label>
        </div>
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input style="margin-bottom: 50px" type="submit" value="Login">
      </form>
    </div>
</body>
</html>