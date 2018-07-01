<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h1>Login to Start the Test</h1>
		<table>
			<form:form action="/user/login" method="post" modelAttribute="user">
				<form:hidden path="userId" />
				<tr>
					<td>Username:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Start Test"></td>
				</tr>
			</form:form>
		</table>
	</div>

</body>
</html>