package quiz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer", schema = "app")
public class AnswerEntity {
	//fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
//	@ManyToMany
//	@JoinTable(name = "submission_answer", schema = "app", joinColumns = @JoinColumn(name = "answer_id")
//			  , inverseJoinColumns = @JoinColumn(name = "question_id"))
//	private List <QuestionEntity> questionEntities;
	
	@ManyToOne
	@JoinColumn(name = "question_id") //name maps to the FK in the table
	private QuestionEntity questionEntity; 
	
	private String text;
	
	@Column(name = "isCorrect")
	private char correct; // cannot be converted to boolean?	
		
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
	
	public char isCorrect() {
		return correct;
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
		return "AnswerEntity [id=" + id + "," + ", text=" + text + ", correct="
				+ correct + "]";
	}
	
	
} //end: class
