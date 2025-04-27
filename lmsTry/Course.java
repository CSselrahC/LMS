package lmsTry;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String code;
	private String title;
	private List<Content> contents = new ArrayList<>();
	private List<Activity> activities = new ArrayList<>();
	private List<Student> students = new ArrayList<>();
	private Instructor instructor;
	
	public Course(String code, String title, Instructor instructor) {
		this.code = code;
		this.title = title;
		this.instructor = instructor;
	}
	
	// Getter Methods
	public String getCode()				{return code;}
	public String getTitle()			{return title;}
	public List<Content> getContents()	{return contents;}
	public List<Student> getStudents()	{return students;}
	public Instructor getInstructor()	{return instructor;}
	
	// Setter Methods
	public void setCode(String code)					{this.code = code;}
	public void setTitle(String title)					{this.title = title;}
	public void setInstructor(Instructor instructor)	{this.instructor = instructor;}
	
	public void enrollStudent(Student student) {
		students.add(student);
	}
	
	public void dropStudent(Student student) {
		for(Student currentStudent : students) {
			if(currentStudent.equals(student)) {
				students.remove(currentStudent);
				student.dropCourse(this);
			}
		}
	}
	
	public void createActivity() {
		String name = "";
		String description = "";
		String type = "";
		String datePosted = "";
		String dateDue = "";
		Activity activity = new Activity(name, description, type, datePosted, dateDue, this);
		activities.add(activity);
	}
	
	public void deleteActivity(Activity activity) {
		for(Activity currentActivity : activities) {
			if(currentActivity.equals(activity)) {
				activities.remove(currentActivity);
			}
		}
	}

	public class Activity {
		private String name;
		private String description;
		private String type;
		private String datePosted;
		private String dateSubmitted;
		private String dateDue;
		private Course course;
		private boolean submitted;
		private boolean viewed;
		
		public Activity(String name, String description, String type, String datePosted, String dateDue, Course course) {
			this.setName(name);
			this.setDescription(description);
			this.setType(type);
			this.setDatePosted(datePosted);
			this.setDateSubmitted("Not yet submitted");
			this.setDateDue(dateDue);
			this.course = course;
			this.setSubmitted(false);
			this.setViewed(false);
		}
		
		// Getter Methods
		public String getName()				{return name;}
		public String getDescription()		{return description;}
		public String getType()				{return type;}
		public String getDatePosted()		{return datePosted;}
		public String getDateSubmitted()	{return dateSubmitted;}
		public String getDateDue()			{return dateDue;}
		public Course getCourse()			{return course;}
		public boolean isSubmitted()		{return submitted;}
		public boolean isViewed()			{return viewed;}
		
		// Setter Methods
		public void setName(String name)					{this.name = name;}
		public void setDescription(String description)		{this.description = description;}
		public void setType(String type)					{this.type = type;}
		public void setDatePosted(String datePosted)		{this.datePosted = datePosted;}
		public void setDateSubmitted(String dateSubmitted)	{this.dateSubmitted = dateSubmitted;}
		public void setDateDue(String dateDue)				{this.dateDue = dateDue;}
		public void setSubmitted(boolean submitted)			{this.submitted = submitted;}
		public void setViewed(boolean viewed)				{this.viewed = viewed;}
	}
}
