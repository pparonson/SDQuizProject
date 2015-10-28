package quiz.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "answer")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String value;
	@Column(name = "isCorrect")
	private boolean correct;
	private String text;
	
	public Answer(String value, boolean correct) {
		this.value = value;
		this.correct = correct;
	}

	public String getValue() {
		return value;
	}

	void setValue(String value) {
		this.value = value;
	}

	public boolean isCorrect() {
		return correct;
	}

	void setCorrect(boolean correct) {
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
		return "Answer [value=" + value + ", correct=" + correct + "]";
	}
}
