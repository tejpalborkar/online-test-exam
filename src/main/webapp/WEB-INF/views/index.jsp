<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home-Online Test Exam Maker</title>
<spring:url value="/resources/css/style.css" var="mainCss" />
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />


<link rel="stylesheet" type="text/css" href="${mainCss}">

<script src="${jqueryJs}">



</script>

<script type="text/javascript">


	$(document).ready(function() {

	$("form").submit(function(event) {
			if ($("#userName").val().length == 0 || $("#password").val().length ==0) {
				event.preventDefault();
			}
		});
	});
</script>
</head>
<body>
	<div class="main-div">
		<div class="index-div-align-left">
			Exam Name
			<p>${exam.examName}
			<p>
			<p>${exam.description}
			<p>
		</div>

		<div class="index-div-align-center">
			<h1>Login to Start the Test</h1>
			<table>
				<form:form action="user/login" method="post" modelAttribute="user">
					<form:hidden path="userId" />
					<tr>
						<td>Username:</td>
						<td><form:input path="userName" id="userName"/></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:password path="password"  id="password" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" id="submit"
							value="Start Test"></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>