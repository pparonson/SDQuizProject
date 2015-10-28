package quiz.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quiz_submission", schema = "app")
public class QuizSubmissionEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private AccountEntity accountEntity;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private QuizEntity quizEntity;
	
	//submission_time
	@Column(name = "submission_time")
	private Date submissionTime; //get java timeStamp

//	Getters and Setters
	public Date getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(Date submissionTime) {
		this.submissionTime = submissionTime;
	}

	public int getId() {
		return id;
	}

	public AccountEntity getAccountEntity() {
		return accountEntity;
	}

	public QuizEntity getQuizEntity() {
		return quizEntity;
	}
	
} //end: class
