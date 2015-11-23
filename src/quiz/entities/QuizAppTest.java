package quiz.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class QuizAppTest {
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("SDQuizProject");
		em = emf.createEntityManager();
		QuizEntity quizEntity = em.find(QuizEntity.class, 1); //1 is the primary key of the db quiz table
		QuestionEntity questionEntity = em.find(QuestionEntity.class, 2); //1 is the primary key of the db quiz table
		AnswerEntity answerEntity = em.find(AnswerEntity.class, 1);
		AccountEntity accountEntity = em.find(AccountEntity.class, 1);
		
//		create new account entity
		String queryAccountEntity = "SELECT a FROM AccountEntity a";
		
        List<AccountEntity> accountList = em.createQuery(queryAccountEntity).getResultList();
        for (AccountEntity account : accountList) {
             System.out.println(account.getUserName()
            		 );
        }
        
        System.out.println("Size: " + accountList.size());

		em.clear();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
	        AccountEntity account = new AccountEntity();
	        account.setUserName("janice");
	        account.setPassword("janice");
	        account.setEmail("janice@example.com");
	        Date currentDate = new Date();
	        account.setRegistrationDate(currentDate);
	        
			em.persist(account);
			et.commit(); 
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (et != null && et.isActive()) {
					et.rollback();
				}//end: if
			} finally {
				if (em != null && em.isOpen()) {
					em.close();
				}//end: if
			}//end: finally
		}//end: try-catch-finally

		System.out.println("Size: " + accountList.size());
        
        
		
//		System.out.println("QuizEntity: " + quizEntity.getName());
//		System.out.println("QuestionEntity: " + questionEntity.getText() );
//		System.out.println("AnswerEntity: " + answerEntity.getText());
//		System.out.println("AccountEntity: " + accountEntity.getEmail());
//		System.out.println("AccountEntity: " + accountEntity.getUserName());
//		System.out.println("AccountEntity: " + accountEntity.getPassword());
//		System.out.println("AccountEntity: " + accountEntity.getRegistrationDate());

//		List <QuestionEntity> questions = quizEntity.getQuestionEntities();
//		for (QuestionEntity question : questions) {
//			System.out.println(question.getText());
//		} //end: foreach		
		
//		List <AnswerEntity> answers = questionEntity.getAnswerEntities();
//		for (AnswerEntity answer : answers) {
//			System.out.println(answer.getText());
//		} //end: foreach
		
		

//		em.close();
		emf.close();
	}//end: main
} //end: class