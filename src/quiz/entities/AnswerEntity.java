package quiz.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "answer", schema = "app")
public class AnswerEntity {
	//fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	private String text;
	
	@Column(name = "isCorrect")
	private char correct; 
	
	@ManyToOne
	@JoinColumn(name = "question_id")//name maps to the FK in the table
	private QuestionEntity questionEntity; 
	
	@OneToMany(mappedBy = "answerEntity")//mappedBy element is the name of the reference field on the target side
	private List <SubmissionAnswerEntity> submissionAnswerEntities;
		
public List<SubmissionAnswerEntity> getSubmissionAnswerEntities() {
		return submissionAnswerEntities;
	}

	public void setSubmissionAnswerEntities(List<SubmissionAnswerEntity> submissionAnswerEntities) {
		this.submissionAnswerEntities = submissionAnswerEntities;
	}

	public void setQuestionEntity(QuestionEntity questionEntity) {
		this.questionEntity = questionEntity;
	}

	//	constructor
	public AnswerEntity() {
		
	} //end: constr
	
	public AnswerEntity(int id, QuestionEntity questionEntity, String text, char correct) {
	this.id = id;
	this.questionEntity = questionEntity;
	this.text = text;
	this.correct = correct;
	} //end: constr
	
//	getters and setters
	public int getId() {
		return id;
	}
	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}
//	public char isCorrect() {
//		return correct;
//	}
	public String getCorrect() {
		return  Character.toString(correct);
	}
	public void setCorrect(char correct) {
		this.correct = correct;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return null;
	}
	
} //end: class
