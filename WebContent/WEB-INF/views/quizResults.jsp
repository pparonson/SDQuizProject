<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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
    <link href='https://fonts.googleapis.com/css?family=Special+Elite'
          rel='stylesheet'
          type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Permanent+Marker'
          rel='stylesheet'
          type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
    </script>
<title>Results</title>
</head>
<body class="container">
    <div>
	    <h2 class="titlePage">Thanx for playin' QuizApp!</h2>
    </div>
    <div>Summary of results for: ${quizSubmission.accountEntity.userName}</div>
	<div>Quiz: ${quiz.name}</div>
	<div>Date: ${quizSubmission.submissionTime}</div>
 	<div>
		<form class="container2">
	 		<table>
	        	<th class="tableHeader">Question</th>
	        	<th class="tableHeader">Correct</th>
	        	<th class="tableHeader">${quizSubmission.accountEntity.userName}</th>
	        	</tr>
 	            	<c:forEach var="i"
                               items="${quizSubmission.submissionAnswerEntities}">
		        	<tr class="tableRow">
		                <td class="tableData">${i.questionEntity.text}</td>
		                <c:forEach var="j"
                                   items="${i.questionEntity.answerEntities}">
  	            			<c:if test='${j.correct.equals("Y")}'>
								<td class="tableData">${j.text}</td>
  							</c:if>
  						</c:forEach>
 		                <td class="tableData">${i.answerEntity.text}</td>
	                </tr>
	        	</c:forEach>
	  		</table>
	    </form>
    </div>
</body>
</html>
