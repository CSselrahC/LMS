package lmsTry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainConsoleBased {
	static Scanner scan = new Scanner(System.in);
	static AccountManager accountManager = new AccountManager();
	static CourseManager courseManager = new CourseManager(accountManager);
	
	public static void main(String[] args) {
		accountManager.setCourseManager(courseManager);
//		login();
//		
//		User user = accountManager.getLoggedInAccount();
//		System.out.print("[" + user.getUserType() + "] " + user.getId());
//		System.out.println(" Name: " + user.getLastName() + ", " + user.getFirstName());
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
