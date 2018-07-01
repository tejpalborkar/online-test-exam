<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<spring:url value="/resources/css/style.css" var="mainCss" />
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />


<link rel="stylesheet" type="text/css" href="${mainCss}">
</head>

<body>
	<span style="margin: 10px"> ${question.questionText}</span>
	<input type="hidden" id="currentQuestionId" value="${question.questionId}">
	<ul>
		<c:forEach var="ans" items="${question.answers}">
					${ans.ansIndex}. <input type="radio" name="answer" 
				value="${ans.ansIndex}"> ${ans.ansText}<br>
		</c:forEach>
	</ul>
</body>
</html>
