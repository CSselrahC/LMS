package lmsTry;

import java.util.List;

public class Admin extends User {
	private AccountManager accountManager;
	private CourseManager courseManager;
	
	public Admin(AccountManager accountManager) {
		super("001", "Admin", "Admin", "secret123", "Admin");
		this.accountManager = accountManager;
	}
	
	public void setCourseManager(CourseManager courseManager) {this.courseManager = courseManager;}
	
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
		boolean userIsFound = false;
		
		if(user.getUserType().equals("Student")) {
			List<Student> studentList = accountManager.getStudentList();
			Student studentRemove = null;
			for(Student student : studentList) {
				if(student.equals(user)) {
					userIsFound = true;
					studentRemove = student;
				}
			}
			
			if(userIsFound) {
				accountManager.removeStudentAccount(studentRemove);
			}
		}
		
		if(user.getUserType().equals("Instructor")) {
			List<Instructor> instructorList = accountManager.getInstructorList();
			Instructor instructorRemove = null;
			for(Instructor instructor : instructorList) {
				if(instructor.equals(user)) {
					userIsFound = true;
					instructorRemove = instructor;
				}
			}
			
			if(userIsFound) {
				accountManager.removeInstructorAccount(instructorRemove);
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
		boolean courseIsFound = true;
		
		for(Course currentCourse : courses) {
			if(currentCourse.equals(course)) {
				courseIsFound = true;
			}
		}
		
		if(courseIsFound) {
			courseManager.removeCourse(course);
		}
	}
	
	public void assignInstructorAt(Course course) {
		Instructor assignedInstructor = null;
		course.setInstructor(assignedInstructor);
	}
	
	public void generateReport() {
		
	}
}
