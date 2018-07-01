<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>End Exam</title>
</head>

<spring:url value="/resources/css/style.css" var="mainCss" />
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />


<link rel="stylesheet" type="text/css" href="${mainCss}">

<script src="${jqueryJs}"></script>

<body>
<script type="text/javascript">



$(document).ready(function() {
	var message = '${message}';
// 	alert(message.length)
	console.log(message)
	if( message.length > 0){
		$("#summaryDiv").hide();
	 	$("#messageTextDiv").html("Your score is : "+message);
	 	$("#messageTextDiv").show();
	 	$("#toLogin").show();
	}	
});



</script>
	<div class="div-align-center" id="">
		<div class="div-align-center1" id="summaryDiv">
			Total Questions Answered: ${totalQuestionsAnswered}<br /> Total
			Un-Answered Questions: ${totalUnAnswered}<br /> Click here to confirm
			test submission: <a href="confirmSubmission">Confirm Submission</a>
		</div>
		<div class="div-align-center1" style="display: none"
			id="messageTextDiv"></div>
		<div id="toLogin" style="display: none; margin:10px ">
				Click here to take new test: <a href="<%=request.getContextPath() %>">New Test</a>
		</div>
	</div>
</body>
</html>