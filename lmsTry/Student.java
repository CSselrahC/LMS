package lmsTry;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	private Profile profile;
	private List<Course> enrolledCourses = new ArrayList<>();
	
	public Student(String id, String lastName, String firstName, String password) {
		super(id, lastName, firstName, password, "Student");
		this.profile = new Profile(this);
	}
	
	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	
	public void editProfile() {
		String studentNumber = "";
		String sexAtBirth = "";
		String civilStatus = "";
		String residency = "";
		String nationality = "";
		String religion = "";
		String dateOfBirth = "";
		String placeOfBirth = "";
		
		profile.setStudentNumber(studentNumber);
		profile.setSexAtBirth(sexAtBirth);
		profile.setCivilStatus(civilStatus);
		profile.setResidency(residency);
		profile.setNationality(nationality);
		profile.setReligion(religion);
		profile.setDateOfBirth(dateOfBirth);
		profile.setPlaceOfBirth(placeOfBirth);
	}
	
	public void enrollCourse(Course course) {
		enrolledCourses.add(course);
		course.enrollStudent(this);
	}
	
	public void dropCourse(Course course) {
		for(Course currentCourse : enrolledCourses) {
			if(currentCourse.equals(course)) {
				enrolledCourses.remove(currentCourse);
				course.dropStudent(this);
			}
		}
	}
	
	public void submitActivity() {
		
	}
	
	public class Profile {
		private String studentNumber;
		private String sexAtBirth;
		private String civilStatus;
		private String residency;
		private String nationality;
		private String religion;
		private String dateOfBirth;
		private String placeOfBirth;
		private Student student;
		
		public Profile(Student student) {
			this.student = student;
		}
		
		// Getter Methods
		public String getStudentNumber()	{return studentNumber;}
		public String getSexAtBirth()		{return sexAtBirth;}
		public String getCivilStatus()		{return civilStatus;}
		public String getResidency()		{return residency;}
		public String getNationality()		{return nationality;}
		public String getReligion()			{return religion;}
		public String getDateOfBirth()		{return dateOfBirth;}
		public String getPlaceOfBirth()		{return placeOfBirth;}
		public Student getStudent()			{return student;}
		
		// Setter Methods
		public void setStudentNumber(String studentNumber)	{this.studentNumber = studentNumber;}
		public void setSexAtBirth(String sexAtBirth)		{this.sexAtBirth = sexAtBirth;}
		public void setCivilStatus(String civilStatus)		{this.civilStatus = civilStatus;}
		public void setResidency(String residency)			{this.residency = residency;}
		public void setNationality(String nationality)		{this.nationality = nationality;}
		public void setReligion(String religion)			{this.religion = religion;}
		public void setDateOfBirth(String dateOfBirth)		{this.dateOfBirth = dateOfBirth;}
		public void setPlaceOfBirth(String placeOfBirth)	{this.placeOfBirth = placeOfBirth;}
	}
}
