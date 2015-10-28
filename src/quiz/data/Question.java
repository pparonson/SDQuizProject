package quiz.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String value;
	@OneToMany(mappedBy = "answer") //ref back to answer, but no mapping on answer side
	private List<Answer> answers;
	private String givenAnswer;
	private String text;
//	private int count;

	public Question(int id, String value, List<Answer> answers) {
		this.id = id;
		this.value = value;
		this.answers = answers;
	}

	
	
	public String getValue() {
		return value;
	}

	void setValue(String value) {
		this.value = value;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getGivenAnswer() {
		return givenAnswer;
	}
	
	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}

	int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Answer getCorrectAnswer() {
		for (Answer answer : answers) {
			if (answer.isCorrect())
				return answer;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", value=" + value + ", answers="
				+ answers + ", givenAnswer=" + givenAnswer + "]";
	}
}
