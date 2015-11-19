<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css"
		  rel="stylesheet"
		  href="stylesheets/reset.css">
    <link type="text/css"
		  rel="stylesheet"
		  href="stylesheets/menuStyles.css">
    <%-- <link href='https://fonts.googleapis.com/css?family=Special+Elite'
		  rel='stylesheet'
		  type='text/css'> --%>
    <link href='https://fonts.googleapis.com/css?family=Permanent+Marker'
		  rel='stylesheet'
		  type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- complete script tag -->
<title>Quiz Form</title>
</head>
<body>
	<c:choose>
		<c:when test="${count < quiz.getQuestionEntities().size() - 1}">
			<h2 class="titlePage">${quiz.name}</h2>
  			<c:if test="${count < 1}">
				<div class="quizDiv">
					This quiz has ${quiz.getQuestionEntities().size()} questions.
				</div>
  			</c:if>
		  	<div class="quizDiv">Question #: ${count + 1}</div>
		  	<div class="quizDiv" id="quizQuestion">
				${quiz.getQuestionEntities().get(count).getText()}
			</div>
 			<form action="quizQuestion.do"
				  method="post"
				  class="quizDiv">
				<table class="questionList">
					<c:forEach var="i" items="${quiz.getQuestionEntities().get(count).getAnswerEntities()}">
						<p class="userResponse">
							<input type="radio"
								   id="${count}"
							   	   name="userResponse"
							       value="${i.text}">
								   <%-- broken custom css radio button using label --%>
								   <label for="${count}"><span>${i.text}</span></label>
								   <%-- ${i.text} --%>
						</p>
					</c:forEach>
				</table>
				<input class="btnSubmit" type="submit">
			</form>
  		</c:when>
  		<c:otherwise>
  			<h2 class="titlePage">${quiz.name}</h2>
  			<div class="quizDiv">Question #: ${count + 1}</div>
		  	<div class="quizDiv"
				 id="quizQuestion">
				 ${quiz.getQuestionEntities().get(count).getText()}
			</div>
 			<form action="quizResultSummary.do"
				  method="post"
				  class="quizDiv">
				<table class="questionList">
					<c:forEach var="i" items="${quiz.getQuestionEntities().get(count).getAnswerEntities()}">
						<p class="userResponse">
							<input type="radio"
								   id="radio02"
							       name="userResponse"
							       value="${i.text}">
								<label for="radio02"><span></span>${i.text}</label>
								<%-- ${i.text} --%>
						</p>
					</c:forEach>
				</table>
				<input class="btnSubmit" type="submit" value="Get results!">
			</form>
  		</c:otherwise>
	</c:choose>
</body>
</html>
