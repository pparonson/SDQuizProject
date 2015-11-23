<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="sdQuizApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css"
		  rel="stylesheet"
		  href="stylesheets/reset.css">
    <link type="text/css"
		  rel="stylesheet"
		  href="stylesheets/menuStyles.css">
<!--    	<link rel="stylesheet"
		  href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">  -->  
    <link href="https://fonts.googleapis.com/css?family=Permanent+Marker"
		  rel="stylesheet"
		  type="text/css">
	<link href='https://fonts.googleapis.com/css?family=Reenie+Beanie'
		  rel='stylesheet'
		  type='text/css'>
	<link type="text/css"
          rel="stylesheet"
          href="stylesheets/csshake-slow.min.css">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
	</script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js">
	</script>
	<script src="//code.angularjs.org/1.4.7/angular-messages.min.js"></script>
	<script type="text/javascript" src="./javascripts/sdQuizApp.js"></script>

<title>Index</title>
</head>
<div class="container-fluid">
	<body class="container">
		<h3 id="mainTitle" class="titlePage">Login with your new user name and password!</h3>
		<div ng-controller="mainController"
			 class="quizDiv">
		 	<form action="loadQuiz.do"
				  method="post"
				  name="loginForm"
				  class="inputForm">
		   		<label>
		    		<input class="login"
						   type="text"
						   name="userName" id="userName"
						   placeholder="username" />
		  		</label>

				<label>
					<input class="login"
						   type="text"
						   name="password" id="password"
						   ng-model="field"
						   required minlength="2"
						   placeholder="password" />
				</label>
				<div ng-messages="loginForm.password.$error" role="alert">
					<div ng-message="required">Enter your user name and password</div>
					<div ng-message="minlength, maxlength">
						Your password must be between 2 and 10 characters long
					</div>
				</div>
				<label>
					<input class="btnSubmit" type="submit">
				</label>
			</form>
		</div>
	</body>
</div>
</html>