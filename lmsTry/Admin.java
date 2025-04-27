package lmsTry;

import java.util.List;

public class Admin extends User {
	private AccountManager accountManager;
	private CourseManager courseManager;
	
	public Admin(AccountManager accountManager) {
		super("001", "Admin", "Admin", "secret123", "Admin");
		this.accountManager = accountManager;
	}
	
	public void createUser(String userType) {
		String id = "";
		String lastName = "";
		String firstName = "";
		String temporaryPassword = "";
		
		if(userType.equals("Student")) {
			Student student = new Student(id, lastName, firstName, temporaryPassword);
			accountManager.addStudentAccount(student);
		}
		
		if(userType.equals("Instructor")) {
			Instructor instructor = new Instructor(id, lastName, firstName, temporaryPassword);
			accountManager.addInstructorAccount(instructor);
		}
		
	}
	
	public void deleteUser(User user) {
		if(user.getUserType().equals("Student")) {
			List<Student> studentList = accountManager.getStudentList();
			for(Student student : studentList) {
				if(student.equals(user)) {
					accountManager.removeStudentAccount(student);
				}
			}
		}
		
		if(user.getUserType().equals("Instructor")) {
			List<Instructor> instructorList = accountManager.getInstructorList();
			for(Instructor instructor : instructorList) {
				if(instructor.equals(user)) {
					accountManager.removeInstructorAccount(instructor);
				}
			}
		}
	}
	
	public void createCourse() {
		String code = "";
		String title = "";
		Instructor instructor = null;
		Course course = new Course(code, title, instructor);
		courseManager.addCourse(course);
	}
	
	public void deleteCourse(Course course) {
		List<Course> courses = courseManager.getCourses();
		for(Course currentCourse : courses) {
			if(currentCourse.equals(course)) {
				courseManager.removeCourse(currentCourse);
			}
		}
	}
	
	public void assignInstructorAt(Course course) {
		Instructor assignedInstructor = null;
		course.setInstructor(assignedInstructor);
	}
	
	public void generateReport() {
		
	}
}
