<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Index</title>
</head>
<body>
	<h1>Quiz App!</h1>
	<!-- 	
<a href="http://localhost:8080/SDQuizProject/redirectToLogin.do">Login Here</a><br />	
-->
	<form action="loadQuiz.do" method="post">		
 		<label>
 			<span>User Name:</span><input type="text" name="userName" id="userName">
		</label> 
		
		<label>
			<span>Password:</span><input type="text" name="password" id="password">
		</label>  
		
		<label>
			<input type="submit" />
		</label><br />
		
<!-- 		
		<label>
			<input type="text" name="quizRequest" value="State Capitals">
		</label> 	
  		<label>
			<input type="text" name="quizId" value="1">
		</label>
-->		
	</form>
</body>
</html>