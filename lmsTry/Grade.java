package lmsTry;

public class Grade {
	private Student student;
	private Course course;
	private double maxGrade;
	private double grade;
	
	public Grade(Student student, Course course, double grade) {
		this.student = student;
		this.course = course;
		this.maxGrade = 100.00;
		this.setGrade(grade);
	}
	
	// Getter Methods
	public Student getStudent()			{return student;}
	public Course getCourse()			{return course;}
	public double getMaxGrade()			{return maxGrade;}
	public double getGrade()			{return grade;}
	
	// Setter Method
	public void setGrade(double grade)	{this.grade = grade;}
}
