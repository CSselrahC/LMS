package lmsTry;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
	private List<Student> studentList = new ArrayList<>();
	private List<Instructor> instructorList = new ArrayList<>();
	private Admin admin;
	private User loggedInAccount;
	
	public AccountManager() {
		admin = new Admin(this);
		initializeUsers();
	}
	
	// Getter Methods
	public List<Student> getStudentList()		{return studentList;}
	public List<Instructor> getInstructorList()	{return instructorList;}
	public User getLoggedInAccount()			{return loggedInAccount;}
	
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
		studentList.remove(student);
	}
	
	public void removeInstructorAccount(Instructor instructor) {
		instructorList.remove(instructor);
	}
	
	public void loginPageSelector(String userType) {
		String id = "";
		String password = "";
		
		switch(userType) {
		case "Student":
			// GUI of student login page
			
			id = "";
			password = "";
			
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
			
			id = "";
			password = "";
			
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
			
			id = "";
			password = "";
			
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
