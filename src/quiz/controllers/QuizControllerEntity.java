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
@SessionAttributes(value = {"quiz", "quizId", "count"})
public class QuizControllerEntity {
	
	//Create springMVC entity manager
	@PersistenceContext
	private EntityManager em;

	@ModelAttribute("quizId") 
		public int getQuizId() {
		return 1;
	}
	
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
    
	
//	quizId moved to @ModelAttribute to persist
	@RequestMapping("/loadQuiz.do")
	public ModelAndView loadQuiz(@ModelAttribute("quizId") int quizId
//			, @RequestParam("quizId") int quizId
			, @RequestParam("userName") String userName
			, @RequestParam("password") String password
			, @ModelAttribute("count") int count) {
		
		QuizEntity quizEntity = em.find(QuizEntity.class, quizId);
		
		String userNameRef = "pparonson";
		String passwordRef = "letMeIn999";
		System.out.println("QuizId: " + quizId);
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
			
			return mv;
			
		} else {
			return new ModelAndView("invalidLogin");

		} //end: else if
		
	} //end: meth
	
//	quiz programming logic
	@RequestMapping("/quizQuestion.do")
	public ModelAndView quizQuestion(@ModelAttribute("quiz") QuizEntity quizEntity
//			, @RequestParam("userResponse") String userResponse
			, @ModelAttribute("quizId") int quizId 
			, @ModelAttribute("count") int count) {
    	
    	List<QuestionEntity> questions = quizEntity.getQuestionEntities();
    	
        if ((count) >= questions.size()) {
        		System.out.println("Inside quizResults condition: " + questions.get(count - 1));
        		
        		
        }//end: if
        
    	
//		if data was submitted from the user
//    	if (count >= questions.size()) {
//    		System.out.println("Inside if conditional; : ");
   			//attempt to use the Question.java methods to set and get the userResponse
    		
   			//get the previous question and set the user's answer to it
//    		ModelAndView mv = new ModelAndView();
//    		mv.addObject("quiz", quizEntity);
//    		mv.setViewName("quizForm");
//    		return mv;
//    	} //end: if
        
    	ModelAndView mv = new ModelAndView();	
    	mv.addObject("quiz", quizEntity);
    	mv.addObject("quizName", quizEntity.getName());
		mv.addObject("numQuestions", quizEntity.getQuestionEntities().size());
    	mv.addObject("questions", quizEntity.getQuestionEntities()); 

    	mv.addObject("currentQuestion", questions.get(count));
    	mv.addObject("answers", questions.get(count).getAnswerEntities());
    	mv.addObject("count", (count += 1));
		mv.setViewName("quizForm");
		
//		testing
//		System.out.println("Inside late quizQuestion method! Loaded new quiz: " 
//				+ " quiz id: " + quizId + ", " 
//				+ "quiz", quizEntity + ", "
//				+ "quiz name: " + quizEntity.getName() + ", " 
//				+ "number of questions: " + quizEntity.getQuestionEntities().size() + ", "
//				+ "questions: " + quizEntity.getQuestionEntities() + ", "
//				subtract 1 from count to avoid out-of-bounds exception
//				+ "currentQuestion: " + questions.get(count - 1) + ", "
//				+ "answers: " + questions.get(count).getAnswerEntities()
//				+ "count: " + count + ", "
//				+ ".");
		
		return mv;
	}//end: m
	
}//end: c






