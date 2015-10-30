package quiz.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "submission_answer", schema = "app")
public class SubmissionAnswerEntity {
	@ManyToOne
	@JoinColumn(name = "user_id")
	private AccountEntity accountEntity;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private QuizEntity quizEntity;
}
