<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="stylesheets/reset.css">
    <link type="text/css" rel="stylesheet" href="stylesheets/menuStyles.css">
    <link href='https://fonts.googleapis.com/css?family=Special+Elite' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Permanent+Marker' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- complete script tag -->
<title>Quiz Form</title>
</head>
<body class="container">
	<c:choose>
		<c:when test="${count < quiz.getQuestionEntities().size() - 1}">
			<h2>${quiz.name}</h2>
  			<c:if test="${count < 1}">
				<div>This quiz has ${quiz.getQuestionEntities().size()} questions.</div>
  			</c:if>
		  	<div>Question #: ${count + 1}</div>
		  	<div>${quiz.getQuestionEntities().get(count).getText()}</div>
 			<form action="quizQuestion.do" method="post">
				<table>
					<c:forEach var="i" items="${quiz.getQuestionEntities().get(count).getAnswerEntities()}">
						<br />
						<input type="radio" name="userResponse" value="${i.text}">${i.text}<br />
					</c:forEach>
				</table>
				<input type="submit">
			</form>
  		</c:when>
  		<c:otherwise>
  			<h2>${quiz.name}</h2>
  			<div>Question #: ${count + 1}</div>
		  	<div>${quiz.getQuestionEntities().get(count).getText()}</div>
 			<form action="quizResultSummary.do" method="post">
				<table>
					<c:forEach var="i" items="${quiz.getQuestionEntities().get(count).getAnswerEntities()}"><br />
						<input type="radio" name="userResponse" value="${i.text}">${i.text}<br />
					</c:forEach>
				</table>
<!-- 			<label>
		 	 		<input type="text" name="quizId" value="1">
				</label>  -->
				<input type="submit" value="Display results!">
			</form>
  		</c:otherwise>
	</c:choose>
</body>
</html>
