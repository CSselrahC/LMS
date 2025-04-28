package lmsTry;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
	private static CourseManager instance;
	private List<Course> courses = new ArrayList<>();
	private AccountManager accountManager;
	
	public CourseManager(AccountManager accountManager) {
		this.accountManager = accountManager;
		initializeCourses();
		initializeEnrolledStudents();
	}
	
	// Getter Methods
	public static CourseManager getInstance()	{return instance;}
	public List<Course> getCourses()			{return courses;}
	
	// Setter Methods
	public static void setInstance(CourseManager instance)			{CourseManager.instance = instance;}
	public void setCourses(List<Course> courses)					{this.courses = courses;}
	public void setAccountManager(AccountManager accountManager)	{this.accountManager = accountManager;}
	
	public void initializeCourses() {
		List<Instructor> instructors = accountManager.getInstructorList();
		Course course1 = new Course("CCS108", "Object-Oriented Programming", instructors.get(0));
		Course course2 = new Course("CAR101", "Introduction to Vehicles", instructors.get(2));
		Course course3 = new Course("NIN101", "Ninjitsu in the Modern World", instructors.get(1));
		
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
	}
	
	public void initializeEnrolledStudents() {
		List<Student> students = accountManager.getStudentList();
		students.get(0).enrollCourse(courses.get(2));
		students.get(1).enrollCourse(courses.get(2));
		students.get(2).enrollCourse(courses.get(2));
		students.get(2).enrollCourse(courses.get(0));
		students.get(3).enrollCourse(courses.get(0));
		students.get(4).enrollCourse(courses.get(1));
		students.get(4).enrollCourse(courses.get(0));
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void removeCourse(Course course) {
		boolean courseIsFound = false;
		
		for(Course currentCourse : courses) {
			if(currentCourse.equals(course)) {
				courseIsFound = true;
				course.getInstructor().removeHandledCourse(course);
				
				for(int i = 0; i < course.getStudents().size(); i++) {
					course.getStudents().get(i).dropCourse(course);
				}
			}
		}
		
		if(courseIsFound) {
			courses.remove(course);
		}
	}
}
