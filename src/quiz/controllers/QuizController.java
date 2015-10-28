package quiz.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import quiz.data.Question;
import quiz.data.QuizDB;

//@Controller
public class QuizController {
//	Declarations for scope
//	QuizInMemory qdb = new QuizInMemory();
	
	QuizDB qdb = new QuizDB(); //refactor qim to qdb to change to database
    Question currentQuestion = null;
	

	@RequestMapping("/postQuizRequest.do")
	public ModelAndView quizRequest(@RequestParam("quizRequest") String quizRequest) {
		if (quizRequest.equals(qdb.getQuizName())) {
			
			qdb.setCount(0);
			//obtain and display the questions in an iterable fashion to the form
			List<Question> questions = qdb.getQuestions();
	        if (qdb.getCount() <= questions.size()) {
	        	currentQuestion = questions.get(qdb.getCount());
	        	
	    		System.out.println("quizRequest1 - postQuizRequest.do" + qdb.getCount());
	    		System.out.println("Current Question: " + currentQuestion.toString());

	        }//end: if
		}//end: if
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("quizForm");
		mv.addObject("quizName", qdb.getQuizName());
		mv.addObject("numQuestions", qdb.getNumberOfQuestions());
		mv.addObject("count", qdb.addCount() + "");
		mv.addObject("currentQuestion", currentQuestion);
		System.out.println("quizRequest2 - postQuizRequest.do" + qdb.getCount());

		return mv;
	}//end: m

	
	@RequestMapping("/postQuizForm.do")
		public ModelAndView quizResponse(@RequestParam("userResponse") String userResponse) {
	    	System.out.println("Question count: " + qdb.getCount());
        	List<Question> questions = qdb.getQuestions();

        	//if data was submitted from the user
        	if (userResponse != null) {
	        	
        		currentQuestion = questions.get(qdb.getCount() - 1);
       			System.out.println("quizResponse1 - postQuizForm.do" + qdb.getCount());

       			//attempt to use the Question.java methods to set and get the userResponse
       			currentQuestion.setGivenAnswer(userResponse);

       			//get the previous question and set the user's answer to it
       			System.out.println("Submitted answer is:" + currentQuestion.getGivenAnswer());
    	    	System.out.println("Question count for submitted answer is: " + qdb.getCount());
       			System.out.println("Correct answer is:" + currentQuestion.getCorrectAnswer());
    	    	System.out.println("Question count for correct answer is: " + qdb.getCount());

       			
        		if (userResponse.equals(currentQuestion.getCorrectAnswer().getValue())) {
        			System.out.println("You answered: " + userResponse + "... You got it!");
//       			System.out.println(qim.getResults());
       			} else {
       				System.out.println("The correct answer was: " + currentQuestion.getCorrectAnswer());
       			}//end: if	 
        		
        		//again, checking if end of array
    	        if (qdb.getCount() < qdb.getQuestions().size()) {
    	        	currentQuestion = questions.get(qdb.getCount());//iterate back
    	        	System.out.println("Not at end of array.");
    	        	
    	        }//end:if
       		}//end: if
        	
	        //if you have reached the end of the quiz
	        if (qdb.getCount() >= qdb.getQuestions().size()) {
//	        	System.out.println("Results:" + qdb.getResults());
	        	
	            List<String[]> quizSummary = new ArrayList<String[]>();
	            for (Question q : questions) {
//	                System.out.println(currentQuestion.getGivenAnswer() + "!");
	                String correctAnswer = currentQuestion.getCorrectAnswer().toString(); //Answer object
	                String givenAnswer = currentQuestion.getGivenAnswer();
	                String[] questionResult = { q.toString(), correctAnswer, givenAnswer };
	                quizSummary.add(questionResult);
	            }//end: for
//	            System.out.println("Result: " + qdb.getResults());
	            System.out.println("Quiz summary: " + quizSummary);
	            
	        	ModelAndView mv = new ModelAndView();
	        	mv.setViewName("quizResults");
	        	mv.addObject("quizName", qdb.getQuizName());
//	        	mv.addObject("results", qdb.getResults());
	        	mv.addObject("quizSummary", quizSummary);
	        	return mv;
	        }//end: if

			ModelAndView mv = new ModelAndView();
			mv.setViewName("quizForm");
			mv.addObject("count", qdb.addCount());
			mv.addObject("userResponse", userResponse);
			mv.addObject("currentQuestion", currentQuestion);
			System.out.println("quizResponse2 - postQuizForm.do" + qdb.getCount());

			return mv;
	}//end: m

}//end: c







