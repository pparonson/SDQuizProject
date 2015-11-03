package quiz.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "account", schema = "app")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	private String email;
	
	@Temporal(TemporalType.DATE) //@Temporal(TemporalType.DATE) versus @Temporal(DATE)
	@Column(name = "registration_date")
	private Date registrationDate;
	
	@OneToMany(mappedBy = "accountEntity") //mappedBy element is the name of the reference field on the target side
	private List <QuizSubmissionEntity> quizSubmissionEntities;

	//	constructor
	public AccountEntity() {
		
	}

//	Getters and Setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getId() {
		return id;
	}

	public List<QuizSubmissionEntity> getQuizSubmissionEntities() {
		return quizSubmissionEntities;
	}

	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", registrationDate=" + registrationDate + ", quizSubmissionEntities=" + quizSubmissionEntities + "]";
	}
	
} //end: class
