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

@Entity
@Table(name = "account", schema = "app")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String userName;
	private String password;
	private String email;
	
	@Column(name = "registration_date")
	private Date registrationDate;
	
	@OneToMany(mappedBy = "accountEntity") //mappedBy element is the name of the reference field on the target side
	private List <QuizSubmissionEntity> quizSubmissionEntities;

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
	
} //end: class
