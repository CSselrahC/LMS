package lmsTry;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	private Profile profile;
	private List<Course> enrolledCourses = new ArrayList<>();
	private List<Grade> grades = new ArrayList<>();
	
	public Student(String id, String lastName, String firstName, String password) {
		super(id, lastName, firstName, password, "Student");
		this.profile = new Profile(this);
	}
	
	// Getter Methods
	public List<Course> getEnrolledCourses()	{return enrolledCourses;}
	public List<Grade> getGrades()				{return grades;}
	public Grade getGradeIn(Course course) {
		for(Grade grade : grades) {
			if(grade.getCourse().equals(course)) {
				return grade;
			}
		}
		
		return null;
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
		boolean courseIsFound = false;
		boolean gradeIsFound = false;
		Grade gradeRemove = null;
		
		for(Course currentCourse : enrolledCourses) {
			if(currentCourse.equals(course)) {
				courseIsFound = true;
				
				for(Grade grade : grades) {
					if(grade.getCourse().equals(currentCourse)) {
						gradeIsFound = true;
						gradeRemove = grade;
					}
				}
			}
		}
		
		if(courseIsFound && gradeIsFound) {
			grades.remove(gradeRemove);
			enrolledCourses.remove(course);
			course.dropStudent(this);
		}
	}
	
	public void addGrade(Grade grade) {
		grades.add(grade);
	}
	
	public void removeGrade(Grade grade) {
		boolean gradeIsFound = false;
		for(Grade currentGrade : grades) {
			if(currentGrade.equals(grade)) {
				gradeIsFound = true;
			}
		}
		
		if(gradeIsFound) {
			grades.remove(grade);
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
