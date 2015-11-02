package quiz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@IdClass(SACID.class)
@Table(name = "submission_answer", schema = "app")
public class SubmissionAnswerEntity {
	//Composite primary key (submission_id, question_id)
	@Id 	
	@Column(name = "submission_id")
	private int submissionId;
	
	@ManyToOne
	@JoinColumn(name = "submission_id", insertable = false, updatable = false) //name maps to the FK in the table
	private QuizSubmissionEntity quizSubmissionEntity;
	
	@Id
	@Column(name = "queston_id")
	private int questionId;
	
	@ManyToOne
	@JoinColumn(name = "question_id", insertable = false, updatable = false) //name maps to the FK in the table
	private QuestionEntity questionEntity; 
	
	@ManyToOne
	@JoinColumn(name = "answer_id") //name maps to the FK in the table
	private AnswerEntity answerEntity;
	
//	getters and setters
	public QuizSubmissionEntity getQuizSubmissionEntity() {
		return quizSubmissionEntity;
	}

	public void setQuizSubmissionEntity(QuizSubmissionEntity quizSubmissionEntity) {
		this.quizSubmissionEntity = quizSubmissionEntity;
	}

	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}

	public void setQuestionEntity(QuestionEntity questionEntity) {
		this.questionEntity = questionEntity;
	}

	public AnswerEntity getAnswerEntity() {
		return answerEntity;
	}

	public void setAnswerEntity(AnswerEntity answerEntity) {
		this.answerEntity = answerEntity;
	}

	@Override
	public String toString() {
		return "SubmissionAnswerEntity [quizSubmissionEntity=" + quizSubmissionEntity + ", questionEntity="
				+ questionEntity + ", answerEntity=" + answerEntity + "]";
	}

}//end: class
