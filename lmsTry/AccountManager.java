package lmsTry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
	private List<Student> studentList = new ArrayList<>();
	private List<Instructor> instructorList = new ArrayList<>();
	private Admin admin;
	private User loggedInAccount;
	private CourseManager courseManager;
	
	public AccountManager() {
		admin = new Admin(this);
		initializeUsers();
	}
	
	// Getter Methods
	public List<Student> getStudentList()		{return studentList;}
	public List<Instructor> getInstructorList()	{return instructorList;}
	public Admin getAdmin()						{return admin;}
	public List<User> getAccountList() {
		List<User> accountList = new ArrayList<>(studentList);
		accountList.addAll(instructorList);
		accountList.add(admin);
		return accountList;
	}
	public User getLoggedInAccount()			{return loggedInAccount;}
	
	// Setter Methods
	public void setCourseManager(CourseManager courseManager) {this.courseManager = courseManager;}
	
	public void initializeUsers() {
		Student student1 = new Student("student001", "Uzumaki", "Naruto", "anaknghokage");
		Student student2 = new Student("student002", "Uchiha", "Sasuke", "edgelord");
		Student student3 = new Student("student003", "Noko", "Shikanoko", "deer");
		Student student4 = new Student("student004", "Torako", "Koshi", "GalitSaDeer");
		Student student5 = new Student("student005", "Kujo", "Jotaro", "STARPLATINUM");
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);
		
		Instructor instructor1 = new Instructor("instructor001", "Cayaga", "Kurt Joshua", "kurt");
		Instructor instructor2 = new Instructor("instructor002", "Carreon", "Charles", "charles");
		Instructor instructor3 = new Instructor("instructor003", "Carandang", "Christian Raphael", "christian");
		Instructor instructor4 = new Instructor("instructor004", "Balinado", "christian", "ian");
		Instructor instructor5 = new Instructor("instructor005", "Escuzar", "Emiel James", "emiel");
		
		instructorList.add(instructor1);
		instructorList.add(instructor2);
		instructorList.add(instructor3);
		instructorList.add(instructor4);
		instructorList.add(instructor5);
	}
	
	public void addStudentAccount(Student student) {
		studentList.add(student);
	}
	
	public void addInstructorAccount(Instructor instructor) {
		instructorList.add(instructor);
	}
	
	public void removeStudentAccount(Student student) {
		for(Student currentStudent : studentList) {
			if(currentStudent.equals(student)) {
				studentList.remove(student);
				
				for(Course course : courseManager.getCourses()) {
					if(course.getStudents().contains(student)) {
						course.dropStudent(student);
					}
				}
			}
		}
	}
	
	public void removeInstructorAccount(Instructor instructor) {
		for(Instructor currentInstructor : instructorList) {
			if(currentInstructor.equals(instructor)) {
				instructorList.remove(instructor);
				
				for(Course course : courseManager.getCourses()) {
					if(course.getInstructor().equals(instructor)) {
						course.setInstructor(null);
					}
				}
			}
		}
	}
	
	public void loginPageSelector(String userType) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter ID: ");
		String id = scan.nextLine();
		System.out.print("Enter Password: ");
		String password = scan.nextLine();
		
		scan.close();
		
		switch(userType) {
		case "Student":
			// GUI of student login page
			
			for(Student student : studentList) {
				if(id.equals(student.getId()) && password.equals(student.getPassword())) {
					loggedInAccount = student;
					
					// succesful login page
				} else {
					// unsuccessful login page
				}
			}
			break;
			
		case "Instructor":
			// GUI of instructor login page
			
			for(Instructor instructor : instructorList) {
				if(id.equals(instructor.getId()) && password.equals(instructor.getPassword())) {
					loggedInAccount = instructor;
					
					// succesful login page
				} else {
					// unsuccessful login page
				}
			}
			break;
			
		case "Admin":
			// GUI of admin login page
			
			if(id.equals(admin.getId()) && password.equals(admin.getPassword())) {
				loggedInAccount = admin;
				
				// succesful login page
			} else {
				// unsuccessful login page
			}
			break;

		default: break;
		}
	}
	
	public void logout() {
		loggedInAccount = null;
		// GUI of student login page
	}
}
