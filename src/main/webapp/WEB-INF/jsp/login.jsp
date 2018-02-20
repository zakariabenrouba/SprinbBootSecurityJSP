<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="path" value="${pageContext.request.contextPath}" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${path}/login" id="loginForm" method="POST">
		<c:if test="${error != null}">
				<p style="color:red;">${error}</p>
		</c:if>
		<c:if test="${message != null}">
				<p style="color:red;">${message}</p>
		</c:if>
		<div class="form-group">
			<label>Username</label> <input
				type="text" required name="username">
		</div>
		<div class="form-group">
			<label>Password</label> <input type="password" required  name="password">
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}"></input>
		<button type="submit">Login</button>
	</form>
</body>
</html>