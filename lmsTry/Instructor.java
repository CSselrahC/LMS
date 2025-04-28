package lmsTry;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {
	private List<Course> handledCourses = new ArrayList<>();
	
	public Instructor(String id, String lastName, String firstName, String password) {
		super(id, lastName, firstName, password, "Instructor");
	}
	
	public List<Course> getHandledCourses() {
		return handledCourses;
	}
	
	public void removeHandledCourse(Course course) {
		for(Course currentCourse : handledCourses) {
			if(currentCourse.equals(course)) {
				handledCourses.remove(course);
			}
		}
	}
	
	public void addContentTo(Course course) {
		
	}
}
