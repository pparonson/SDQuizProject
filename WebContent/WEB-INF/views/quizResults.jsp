<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="stylesheets/reset.css">
    <link type="text/css" rel="stylesheet" href="stylesheets/menuStyles.css">
    <link href='https://fonts.googleapis.com/css?family=Special+Elite' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Permanent+Marker' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>Results</title>
</head>
<body>
    <h2>QuizApp!Summary Results for: ${quiz.name}</h2>
	<form> <!-- action="DisplayQuestions.do" method="post" -->
<%-- 		<table border="1" class="left">
        <tr><th>Question</th><th>Answer</th><th>Response</th></tr>

            <c:forEach var="i" items="${quizSummary}">
                <tr>
	                <td>1<p></p>${i[0]}</td>
	                <td>2<p></p>${i[1]}</td>
	                <td>3<p></p>${i[2]}</td>
                </tr>

                <br/>    
            </c:forEach>
  		</table>  --%>
    </form> 	
</body>
</html>