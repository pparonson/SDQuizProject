package quiz.controllers;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import quiz.entities.AccountEntity;
import quiz.entities.AnswerEntity;
import quiz.entities.QuestionEntity;
import quiz.entities.QuizEntity;
import quiz.entities.QuizSubmissionEntity;
import quiz.entities.SubmissionAnswerEntity;

@Controller
@SessionAttributes(value = {"quiz"
		, "quizId"
		, "quizSubmission"
		, "count"
		})
public class QuizControllerEntity {
	
	//Create springMVC entity manager
	@PersistenceContext
	private EntityManager em;

	@ModelAttribute("quizId") 
		public int getQuizId() {
		return 1;
	}//end: meth
	
    @ModelAttribute("count")
    public int getInitialCount() {
        return 0;
    }//end: meth
    
    @ModelAttribute("quizSubmission")
    public QuizSubmissionEntity getInitialQuizSubmission() {
    	return new QuizSubmissionEntity();
    }//end: meth
    
	//use this method to initialize the quiz object stored in the session
	//returns null because we expect the user to call loadQuiz method
	@ModelAttribute("quiz")
	public QuizEntity getInitialQuiz() {
		return em.find(QuizEntity.class, 1);
//		return null;
	}//end: meth
	
//	quizId moved to @ModelAttribute to persist
	@RequestMapping("/loadQuiz.do")
	public ModelAndView loadQuiz(@ModelAttribute("quiz") QuizEntity quizEntity
//			, @RequestParam("quizId") int quizId
			, @ModelAttribute("quizSubmission") QuizSubmissionEntity quizSubmissionEntity
			, @ModelAttribute("quizId") int quizId
			, @RequestParam("userName") String userName
			, @RequestParam("password") String password
			, @ModelAttribute("count") int count) {
		
//		create entity managers				
		String query = "SELECT a FROM AccountEntity a WHERE a.userName = ?1";
		List<AccountEntity> result = em.createQuery(query, AccountEntity.class).setParameter(1, userName).getResultList();
		
//		grab the accountEntity for the String query
		AccountEntity queryResult = result.get(0);

		if (userName == null || password == null) {
			return new ModelAndView("invalidLogin");
		}//end: if
		
		if(password.length() < 3) {
			return new ModelAndView("invalidLogin");
		}//end: if
		
		if (userName.equals(queryResult.getUserName()) && password.equals(queryResult.getPassword())) {
			quizSubmissionEntity.setAccountEntity(queryResult);
			queryResult.getQuizSubmissionEntities().add(quizSubmissionEntity);
			quizSubmissionEntity.setQuizEntity(quizEntity);
			quizEntity.getQuizSubmissionEntities().add(quizSubmissionEntity);
			Date date = new Date();
			quizSubmissionEntity.setSubmissionTime(date);
						
			ModelAndView mv = new ModelAndView();
			mv.addObject("quiz", quizEntity);
			mv.addObject("count");
			mv.setViewName("quizForm");
			
			return mv;
		} else {
			return new ModelAndView("invalidLogin");
		} //end: else if
		
	} //end: meth
	
	@RequestMapping("/quizQuestion.do")
	public ModelAndView quizQuestion(@ModelAttribute("quiz") QuizEntity quizEntity
			, @ModelAttribute("quizSubmission") QuizSubmissionEntity quizSubmissionEntity
			, @RequestParam("userResponse") String userResponse
			, @ModelAttribute("quizId") int quizId 
			, @ModelAttribute("count") int count) {
		
		SubmissionAnswerEntity submissionAnswerEntity = new SubmissionAnswerEntity();

		QuestionEntity questionEntity = quizEntity.getQuestionEntities().get(count);
		submissionAnswerEntity.setQuestionEntity(questionEntity);
		questionEntity.getSubmissionAnswerEntities().add(submissionAnswerEntity);
		submissionAnswerEntity.setQuizSubmissionEntity(quizSubmissionEntity);
		quizSubmissionEntity.getSubmissionAnswerEntities().add(submissionAnswerEntity);
		
		for (AnswerEntity answerEntity : questionEntity.getAnswerEntities()) {
			if (answerEntity.getText().equals(userResponse)) {
				submissionAnswerEntity.setAnswerEntity(answerEntity);
				answerEntity.getSubmissionAnswerEntities().add(submissionAnswerEntity);
				break;
			}//end: if
		}//end: for
			
    	ModelAndView mv = new ModelAndView();	
    	mv.addObject("quiz", quizEntity);
    	mv.addObject("count", (count += 1));
		mv.setViewName("quizForm");
		
		return mv;
	}//end: meth
	
//	quiz results summary
	@Transactional //annotation for CRUD operations
	@RequestMapping("/quizResultSummary.do")
	public ModelAndView quizResultSummary(@ModelAttribute("quiz") QuizEntity quizEntity
			, @ModelAttribute("quizSubmission") QuizSubmissionEntity quizSubmissionEntity
			, @RequestParam("userResponse") String userResponse
			, @ModelAttribute("quizId") int quizId 
			, @ModelAttribute("count") int count) {
				
		SubmissionAnswerEntity submissionAnswerEntity = new SubmissionAnswerEntity();
		QuestionEntity questionEntity = quizEntity.getQuestionEntities().get(count);
		submissionAnswerEntity.setQuestionEntity(questionEntity);
		questionEntity.getSubmissionAnswerEntities().add(submissionAnswerEntity);
		submissionAnswerEntity.setQuizSubmissionEntity(quizSubmissionEntity);
		quizSubmissionEntity.getSubmissionAnswerEntities().add(submissionAnswerEntity);
		
		for (AnswerEntity answerEntity : questionEntity.getAnswerEntities()) {
			if (answerEntity.getText().equals(userResponse)) {
				submissionAnswerEntity.setAnswerEntity(answerEntity);
				answerEntity.getSubmissionAnswerEntities().add(submissionAnswerEntity);
				break;
			}//end: if
		}//end: for
		
    	ModelAndView mv = new ModelAndView();	
    	mv.addObject("quiz", quizEntity);
    	mv.addObject("quizSubmission", quizSubmissionEntity);
		mv.setViewName("quizResults");
		
//		entity manager operations
//		em.clear();
//		EntityTransaction et = em.getTransaction();
//		et.begin();
		try {
//			for (Quiz submissionAnswerEntity : iterable) {
//				
//			}
			em.persist(quizSubmissionEntity);
//			et.commit(); 
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
//				if (et != null && et.isActive()) {
//					et.rollback();
//				}//end: if
			} finally {
//				if (em != null && em.isOpen()) {
//					em.close();
//				}//end: if
			}//end: finally
		}//end: try-catch-finally
		
		return mv;
	}//end: meth
	
}//end: class






