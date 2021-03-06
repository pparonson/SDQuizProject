package quiz.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question", schema = "app")
public class QuestionEntity {
//	fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String text;
	
	@ManyToMany(mappedBy = "questionEntities") //maps to field name on the owning side
	private List <QuizEntity> quizEntities;
	
	@OneToMany(mappedBy = "questionEntity", fetch = FetchType.EAGER) //mappedBy element is the name of the reference field on the target side
	private List <AnswerEntity> answerEntities;
	
	@OneToMany(mappedBy = "questionEntity") //mappedBy element is the name of the reference field on the target side
	private List <SubmissionAnswerEntity> submissionAnswerEntities;

	//	contructors
	public QuestionEntity() {} //end: constr
	
	public QuestionEntity(int id, String text, List<QuizEntity> quizEntities, List<AnswerEntity> answerEntities) {
		this.id = id;
		this.text = text;
		this.quizEntities = quizEntities;
		this.answerEntities = answerEntities;
	} //end: constr
	
	//	Getters and Setters
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public List<QuizEntity> getQuizEntities() {
		return quizEntities;
	}
	public List<AnswerEntity> getAnswerEntities() {
		return answerEntities;
	}
	public List<SubmissionAnswerEntity> getSubmissionAnswerEntities() {
		return submissionAnswerEntities;
	}

	public void setSubmissionAnswerEntities(List<SubmissionAnswerEntity> submissionAnswerEntities) {
		this.submissionAnswerEntities = submissionAnswerEntities;
	}

	public void setQuizEntities(List<QuizEntity> quizEntities) {
		this.quizEntities = quizEntities;
	}

	public void setAnswerEntities(List<AnswerEntity> answerEntities) {
		this.answerEntities = answerEntities;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
} //end: class
