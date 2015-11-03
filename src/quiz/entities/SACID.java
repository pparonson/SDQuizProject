package quiz.entities;

// separate file to represent "primary key class" for composite key
public class SACID {
	// add fields for each primary key
	private int quizSubmissionEntity; //maps to entity fields
	private int questionEntity; //
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + questionEntity;
		result = prime * result + quizSubmissionEntity;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SACID other = (SACID) obj;
		if (questionEntity != other.questionEntity)
			return false;
		if (quizSubmissionEntity != other.quizSubmissionEntity)
			return false;
		return true;
	}
	
}
