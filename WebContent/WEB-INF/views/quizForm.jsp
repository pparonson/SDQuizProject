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
<body>
	<!-- expression language -->	
	<h2>${quiz.name}</h2>
  	<div>
  		<span>This quiz has</span>
  		<span>${numQuestions}</span>
  		<span>questions.</span>
  	</div>

  	<div>
  		<span>Count: </span>
  		<span>${count}</span>
  	</div>
<%-- 	<div>${questions}</div>	   --%>
		<div>${currentQuestion.text}</div>
<%-- 	
	<div>${questions}</div>	
 	
 	<table border="1" class="left">
   	<tr><th>Question</th>
    	<c:forEach var="i" items="${questions}">
        	<tr>
	        	<td>1<p></p>${i.text}</td>
            </tr>
                <br/>    
        </c:forEach>
  	</table> 
--%>
	<form action="quizQuestion.do" method="post">
	
		<table>
			<c:forEach var="i" items="${answers}">
				<br />
				<input type="radio" name="userResponse" value="${i.text}" />${i.text}<br />
			</c:forEach>
		</table>

	 	<label><input type="text" name="quizId" value="1"></input>
		</label>	 
		<input type="submit" /> 

	</form> 
	
</body>
</html>