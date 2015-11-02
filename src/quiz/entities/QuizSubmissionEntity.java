package quiz.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "quiz_submission", schema = "app")
public class QuizSubmissionEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")//name maps to the FK in the table
	private AccountEntity accountEntity;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")//name maps to the FK in the table
	private QuizEntity quizEntity;
	
	@OneToMany(mappedBy = "quizSubmissionEntity")//mappedBy element is the name of the reference field on the target side
	private List <SubmissionAnswerEntity> submissionAnswerEntities;
	
	//submission_time
	@Temporal(TemporalType.DATE) //@Temporal(TemporalType.DATE) versus @Temporal(DATE)
	@Column(name = "submission_time")
	private Date submissionTime; //get java timeStamp

//	Getters and Setters
	public AccountEntity getAccountEntity() {
		return accountEntity;
	}

	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}

	public QuizEntity getQuizEntity() {
		return quizEntity;
	}

	public void setQuizEntity(QuizEntity quizEntity) {
		this.quizEntity = quizEntity;
	}

	public List<SubmissionAnswerEntity> getSubmissionAnswerEntities() {
		return submissionAnswerEntities;
	}

	public void setSubmissionAnswerEntities(List<SubmissionAnswerEntity> submissionAnswerEntities) {
		this.submissionAnswerEntities = submissionAnswerEntities;
	}

	public Date getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(Date submissionTime) {
		this.submissionTime = submissionTime;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "QuizSubmissionEntity [id=" + id + ", accountEntity=" + accountEntity + ", quizEntity=" + quizEntity
				+ ", submissionAnswerEntities=" + submissionAnswerEntities + ", submissionTime=" + submissionTime + "]";
	}
	
} //end: class
