package quiz.data;

import java.util.ArrayList;
import java.util.List;

public class QuizInMemory implements Quiz{
	private List<Question> questions;
	private String name = "State Capitals";
	private int count;

	public QuizInMemory() {
		loadQuestions();
	}

	// Better to get this from Database
	private void loadQuestions() {
		questions = new ArrayList<>();

		List<Answer> answers1 = new ArrayList<>();
		answers1.add(new Answer("Denver", true));
		answers1.add(new Answer("Pueblo", false));
		answers1.add(new Answer("Boulder", false));
		answers1.add(new Answer("Alamosa", false));
		Question question1 = new Question(1,
				"What is the Capital of Colorado?", answers1);
		questions.add(question1);

		List<Answer> answers2 = new ArrayList<>();
		answers2.add(new Answer("New York City", false));
		answers2.add(new Answer("Buffalo", false));
		answers2.add(new Answer("Albany", true));
		answers2.add(new Answer("Syracuse", false));
		Question question2 = new Question(2,
				"What is the Capital of New York?", answers2);
		questions.add(question2);

		List<Answer> answers3 = new ArrayList<>();
		answers3.add(new Answer("Minneaopolis", false));
		answers3.add(new Answer("St. Paul", true));
		answers3.add(new Answer("Duluth", false));
		answers3.add(new Answer("St. Cloud", false));
		Question question3 = new Question(3,
				"What is the Capital of Minnesota?", answers3);
		questions.add(question3);

	}

	public String getQuizName() {
		return name;
	}
	
	public int getNumberOfQuestions() {
		return questions.size();
	}

	public List<Question> getQuestions() {
		return questions;
	}

	void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return this.count;
	}
//	increment count
	public int addCount() {
		this.count += 1;
		return count;
	}

	public String getResults() {
		StringBuilder builder = new StringBuilder(1024);
		for (Question question : questions) {
			builder.append("Question: " + question.getValue() + "\n");
			List<Answer> answers = question.getAnswers();
			for (Answer answer : answers) {
				if (answer.isCorrect()) {
					builder.append("  *");
				} else {
					builder.append("   ");
				}
				builder.append("Answer: " + answer.getValue() + "\n");
			}
			builder.append("User Answer: " + question.getGivenAnswer());
			if (question.getCorrectAnswer().getValue()
					.equals(question.getGivenAnswer())) {
				builder.append(" --> CORRECT" + "\n");
			} else {
				builder.append(" --> INCORRECT" + "\n");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
}
