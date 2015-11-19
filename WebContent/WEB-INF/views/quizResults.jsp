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
    <link type="text/css"
          rel="stylesheet"
          href="stylesheets/csshake-slow.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
    </script>
<title>Results</title>
</head>
<body class="container">
    <div>
	    <h2 class="titlePage">Thanks for playing!</h2>
    </div>
    <div class="quizDiv">
        <span>Summary of results for: </span>
        ${quizSubmission.accountEntity.userName}
    </div>
	<div class="quizDiv">
        <span>Quiz: </span>
        ${quiz.name}
    </div>
	<div class="quizDiv">
        <span>Date: </span>
        ${quizSubmission.submissionTime}
    </div>
 	<div class="quizDiv">
		<form class="quizForm">
	 		<table>
	        	<th class="tableHeader" id="questionResult">Question</th>
	        	<th class="tableHeader" id="correctResult">Correct</th>
	        	<th class="tableHeader" id="userNameResult">${quizSubmission.accountEntity.userName}</th>
	        	</tr>
 	            	<c:forEach var="i"
                               items="${quizSubmission.submissionAnswerEntities}">
		        	<tr class="tableRow">
		                <td class="tableData" id="questionTableData">${i.questionEntity.text}</td>
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
        <label>
            <div class="shake-slow shake-constant">
                <a href="http://localhost:8080/SDQuizProject/"
                   class="hrefReturnLogin">
                   Quit
                </a>
            </div>
        </label>
    </div>
</body>
</html>
