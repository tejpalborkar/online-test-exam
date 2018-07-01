<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Test</title>
<!-- <link rel="icon" href="./resources/logo.png" type="image/png"> -->

</head>

<spring:url value="/resources/css/style.css" var="mainCss" />
<spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />


<link rel="stylesheet" type="text/css" href="${mainCss}">

<script src="${jqueryJs}"></script>
<script type="text/javascript">

$(document).ready(function() {
	loadQuestion('${questions[0].questionId}');
		$("#navLinkDivId").hide();
		$("#goButtonId").click(function() {
			var id = $("#questionsComboId").val();
			loadQuestion(id);

		});

		$("#nextButton").click(function() {
			var id = $("#currentQuestionId").val();
			id = parseInt(id) + 1;
			loadQuestion(id);
		});
		
		$("#finishTest").click(function() {
			window.location.href = '../finishTest';
		});
		
		$("#submitButton").click(function() {
			var questionId = $("#currentQuestionId").val();
			var ansSubmitted = $('input[name="answer"]:checked').val();
			if(ansSubmitted == undefined){
				alert("Please select answer");
				return;
			}
			$.ajax({
				 url: "../question/submit", 
				 type	 : 'POST',
				 data	: {questionId:questionId,ansSubmitted:ansSubmitted },
				 async: false,
				 success: function(result){
					 questionId = parseInt(questionId) + 1;
					loadQuestion(questionId);
		       }
			 });
		});
		
		
	});
</script>
<script type="text/javascript">
function loadQuestion(id){
	console.log("Question ID: "+id)
	 var response = "";
	 $.ajax({
		 url: "../question/"+id, 
		 type	 : 'GET',
		 async: false,
		 success: function(result){
			 response = result.toString();
			 	$("#questionInfo").html("");
			 	$("#questionInfo").html(response);
       }
	 });
}
</script>
<body>
	<div id="mainDiv" class="main-div">
		<div id="questionLinksDiv" class="div-align-left">
			<ul>
				<c:forEach var="question" items="${questions}">
					<li><a id="questionLink" 
						href="javascript:loadQuestion(${question.questionId})">Question-${question.questionIndex}</a></li>
				</c:forEach>
				
			</ul>
			<select name = "questionId" id="questionsComboId">
				<c:forEach var="question" items="${questions}">
					<option value="${question.questionId}">Question-${question.questionIndex}</option>
				</c:forEach>
			</select>
			<input id="goButtonId" type="Button" value="Go">
		</div>
		<div id="" class="div-align-center">
			<div id="questionInfo"></div>
			<div class="buttons-div">
				<input type="Button" id="submitButton" value="Submit-Answer">
				 <input	type="Button" id="nextButton" value="Next">
				 <input	type="Button" id="finishTest" value="Finish Test">
			</div>
		</div>
	</div>
</body>
