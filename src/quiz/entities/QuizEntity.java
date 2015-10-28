package quiz.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quiz", schema = "app")
public class QuizEntity {
//Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
//	private String text;
	
	@ManyToMany
	@JoinTable(name = "quiz_question", schema = "app", joinColumns = @JoinColumn(name = "quiz_id")
			  , inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List <QuestionEntity> questionEntities; 
	
	@OneToMany(mappedBy = "quizEntity") //mappedBy element is the name of the reference field on the target side
	private List <QuizSubmissionEntity> quizSubmissionEntities;
	
//	constructors
	public QuizEntity() {
		
	} //end: constr
	public QuizEntity(int id, String name, List<QuestionEntity> questionEntities,
			List<QuizSubmissionEntity> quizSubmissionEntities) {
		super();
		this.id = id;
		this.name = name;
		this.questionEntities = questionEntities;
		this.quizSubmissionEntities = quizSubmissionEntities;
	} //end: constr
	
	//	Getters and Setters
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getText() {
//		return text;
//	}
//	public void setText(String text) {
//		this.text = text;
//	}
	public List<QuestionEntity> getQuestionEntities() {
		return questionEntities;
	}
	public List<QuizSubmissionEntity> getQuizSubmissionEntities() {
		return quizSubmissionEntities;
	}
	@Override
	public String toString() {
		return "QuizEntity [id=" + id + ", name=" + name + ", questionEntities=" + questionEntities
				+ ", quizSubmissionEntities=" + quizSubmissionEntities + "]";
	}
	
} //end: class
