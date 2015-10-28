package quiz.controllers;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import quiz.entities.AnswerEntity;
import quiz.entities.QuestionEntity;
import quiz.entities.QuizEntity;

@Controller
@SessionAttributes(value = {"quiz", "count"})
public class QuizControllerEntity {
	//Create springMVC entity manager
	@PersistenceContext
	private EntityManager em;

    @ModelAttribute("count")
    public int getInitialCount() {
        return 0;
    }
    
	//use this method to initialize the quiz object stored in the session
	//returns null because we expect the user to call loadQuiz method
	@ModelAttribute("quiz")
	public QuizEntity getInitialQuiz() {
		return em.find(QuizEntity.class, 1);
//		return null;
	} //end: m
    
	@RequestMapping("/loadQuiz.do")
	public ModelAndView loadQuiz(@RequestParam("quizId") int quizId
			, @RequestParam("userName") String userName
			, @RequestParam("password") String password
			, @ModelAttribute("count") int count){
		QuizEntity quizEntity = em.find(QuizEntity.class, quizId);
		String userNameRef = "pparonson";
		String passwordRef = "letMeIn999";
		
		if (userName == null || password == null) {
			return new ModelAndView("invalidLogin");
		}//end: if
		
		if(password.length() < 8) {
			return new ModelAndView("invalidLogin");
		}//end: if
		
		if (userName.equals(userNameRef) && password.equals(passwordRef)) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("quiz", quizEntity);
			mv.addObject("numQuestions", quizEntity.getQuestionEntities().size());
			mv.addObject("questions", quizEntity.getQuestionEntities()); 
			mv.addObject("count");
			mv.setViewName("quizForm");
			
//			Testing
			System.out.println("Inside loadQuiz method! Loaded new quiz: " 
					+ " quiz id: " + quizId + ", " 
//					+ "quiz name: " + quizEntity + ", " 
//					+ "number of questions: " + quizEntity.getQuestionEntities().size() + ", "
//					+ "questions: " + quizEntity.getQuestionEntities() + ", "
					+ "count: " + count 
					+ ".");
			
			return mv;
			
		} else {
			return new ModelAndView("invalidLogin");

		} //end: else if
		
	} //end: meth
	
//	quiz programming logic
	@RequestMapping("/quizQuestion.do")
	public ModelAndView quizQuestion(@ModelAttribute("quiz") QuizEntity quizEntity
			, @ModelAttribute("count") int count
//			, @RequestParam("userResponse") String userResponse
			) {
    	
    	List<QuestionEntity> questions = quizEntity.getQuestionEntities();
    	System.out.println("Inside early quizQuestion; Count: " + count);
    	
        if (count <= questions.size()) {
    		questions.get(count).getAnswerEntities().get(count);
        }//end: if
    	
//		if data was submitted from the user
//    	if (userResponse != null) {
//    		currentQuestion = questions    questions.get(qdb.getCount() - 1);
//   			System.out.println("quizResponse1 - postQuizForm.do" + qdb.getCount());
//
//   			//attempt to use the Question.java methods to set and get the userResponse
//   			currentQuestion.setGivenAnswer(userResponse);
//
//   			//get the previous question and set the user's answer to it
//   			System.out.println("Submitted answer is:" + currentQuestion.getGivenAnswer());
//	    	System.out.println("Question count for submitted answer is: " + qdb.getCount());
//   			System.out.println("Correct answer is:" + currentQuestion.getCorrectAnswer());
//	    	System.out.println("Question count for correct answer is: " + qdb.getCount());
//    	} //end: if
        
    	ModelAndView mv = new ModelAndView();	
    	mv.addObject("quiz", quizEntity);
    	mv.addObject("quizName", quizEntity.getName());
		mv.addObject("numQuestions", quizEntity.getQuestionEntities().size());
    	mv.addObject("questions", quizEntity.getQuestionEntities()); 

    	mv.addObject("currentQuestion", questions.get(count));
    	mv.addObject("answers", questions.get(count).getAnswerEntities());
    	mv.addObject("count", ++count);
		mv.setViewName("quizForm");
		
		System.out.println("Inside late quizQuestion method! Loaded new quiz: " 
//				+ " quiz id: " + quizId + ", " 
//				+ "quiz", quizEntity + ", "
				+ "quiz name: " + quizEntity.getName() + ", " 
				+ "number of questions: " + quizEntity.getQuestionEntities().size() + ", "
//				+ "questions: " + quizEntity.getQuestionEntities() + ", "
				+ "currentQuestion: " + questions.get(count) + ", "
//				+ "answers: " + questions.get(count).getAnswerEntities()
				+ "count: " + count + ", "

				+ ".");
		
		return mv;
	}//end: m
	
}//end: c






