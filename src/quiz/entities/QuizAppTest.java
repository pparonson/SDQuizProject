package quiz.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
//		AccountEntity accountEntity = em.find(AccountEntity.class, 1);
		
//		System.out.println("QuizEntity: " + quizEntity.getName());
		System.out.println("QuestionEntity: " + questionEntity.getText() );
//		System.out.println("AnswerEntity: " + answerEntity.getText());
//		System.out.println("AccountEntity: " + accountEntity.getEmail());
		
//		List <QuestionEntity> questions = quizEntity.getQuestionEntities();
//		for (QuestionEntity question : questions) {
//			System.out.println(question.getText());
//		} //end: foreach		
		
		List <AnswerEntity> answers = questionEntity.getAnswerEntities();
		for (AnswerEntity answer : answers) {
			System.out.println(answer.getText());
		} //end: foreach
		

		em.close();
		emf.close();
	}//end: main
} //end: class