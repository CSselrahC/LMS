package lmsTry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainConsoleBased {
	static Scanner scan = new Scanner(System.in);
	static AccountManager accountManager = new AccountManager();
	static CourseManager courseManager = new CourseManager(accountManager);
	
	public static void main(String[] args) {
		accountManager.setCourseManager(courseManager);
		
		tryRemoveCourse();
//		login();
//		
//		User user = accountManager.getLoggedInAccount();
//		System.out.print("[" + user.getUserType() + "] " + user.getId());
//		System.out.println(" Name: " + user.getLastName() + ", " + user.getFirstName());
	}
	
	//DEBUGGING METHODS; REMOVE IF DONE
	public static void tryRemoveCourse() {
		Student student = accountManager.getStudentList().get(2);
		
		System.out.println(student.getFirstName() + " " + student.getLastName());
		System.out.println("Enrolled Courses:");
		for(Course course : student.getEnrolledCourses()) {
			System.out.println(course.toString() + " - " + student.getGradeIn(course).getGrade());
		}
		
		Course courseRemove = courseManager.getCourses().get(0);
		accountManager.getAdmin().deleteCourse(courseRemove); // remove OOP
		
		System.out.println("\n--Updated--");
		System.out.println(student.getFirstName() + " " + student.getLastName());
		System.out.println("Enrolled Courses:");
		for(Course course : student.getEnrolledCourses()) {
			System.out.println(course.toString() + " - " + student.getGradeIn(course).getGrade());
		}
	}
	public static void tryRemoveInstructor() {
		List<Instructor> instructors = accountManager.getInstructorList();
		List<Course> courses = courseManager.getCourses();
		System.out.println("Instructor List:");
		for(Instructor instructor : instructors) {
			System.out.println(instructor.toString());
		}
		
		System.out.println("\nAvailable Courses:");
		for(Course course : courses) {
			System.out.println(course.toString() + " - " + Objects.toString(course.getInstructor(), "TBA"));
		}
		
		System.out.println("\nDeleting Instructor " + instructors.get(2).getLastName() + "\'s Account");
		accountManager.getAdmin().deleteUser(accountManager.getInstructorList().get(2)); // remove last instructor
		System.out.println("\nUpdated Instructor List:");
		for(Instructor instructor : instructors) {
			System.out.println(instructor.toString());
		}
		
		System.out.println("\nAvailable Courses:");
		for(Course course : courses) {
			System.out.println(course.toString() + " - " + Objects.toString(course.getInstructor(), "TBA"));
		}
	}
	public static void tryRemoveStudent() {
		List<Student> students = accountManager.getStudentList();
		System.out.println("Student List:");
		for(Student student : students) {
			System.out.println(student.toString());
		}
		
		Course course = courseManager.getCourses().get(2);
		System.out.println("\nList of students enrolled in " + course.getTitle() + " and their grades:");
		for(Student student : course.getStudents()) {
			System.out.print(student.toString() + " - ");
			System.out.println(course.getGradeOf(student).getGrade());
		}
		
		System.out.println("\nDeleting " + students.get(1).getLastName() + "\'s Account");
		accountManager.getAdmin().deleteUser(accountManager.getStudentList().get(1));
		
		System.out.println("\nUpdated Information");
		System.out.println("Student List:");
		for(Student student : students) {
			System.out.println(student.toString());
		}
		
		System.out.println("\nList of students enrolled in " + course.getTitle() + " and their grades:");
		for(Student student : course.getStudents()) {
			System.out.print(student.toString() + " - ");
			System.out.println(course.getGradeOf(student).getGrade());
		}
	}
	
 	public static void login() {
		System.out.println("[1] Student Login");
		System.out.println("[2] Instructor Login");
		System.out.println("[3] Admin Login");
		System.out.print("Select: ");
		int choice = scan.nextInt();
		String userType = "";
		switch(choice) {
		case 1: userType = "Student"; break;
		case 2: userType = "Instructor"; break;
		case 3: userType = "Admin"; break;
		default: break;
		}
		accountManager.loginPageSelector(userType);
	}
	
	public static void viewAccounts() {
		List<User> usersList = new ArrayList<>(accountManager.getStudentList());
		usersList.addAll(accountManager.getInstructorList());
		usersList.add(accountManager.getAdmin());
		
		System.out.println("Accounts List:");
		for(User user : usersList) {
			System.out.print("[" + user.getUserType() + "] " + user.getId());
			System.out.println(" Name: " + user.getLastName() + ", " + user.getFirstName());
		}
	}
	
	public static void viewCourses() {
		System.out.println("Available Courses:");
		for(Course course : courseManager.getCourses()) {
			System.out.print(course.getCode() + " - " + course.getTitle());
			System.out.println(", Instructor: " + course.getInstructor().getLastName() + ", " + course.getInstructor().getFirstName());
		}
	}
}
