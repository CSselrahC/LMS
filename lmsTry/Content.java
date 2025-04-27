package lmsTry;

import java.io.File;

public class Content {
	private String id;
	private String title;
	private String type;
	private File file;
	private Course course;
	
	// Getter Methods
	public String getId()		{return id;}
	public String getTitle()	{return title;}
	public String getType()		{return type;}
	public File getFile()		{return file;}
	public Course getCourse()	{return course;}
	
	// Setter Methods
	public void setId(String id)			{this.id = id;}
	public void setTitle(String title)		{this.title = title;}
	public void setType(String type)		{this.type = type;}
	public void setFile(File file)			{this.file = file;}
	public void setCourse(Course course)	{this.course = course;}
	
	public void displayContent() {}
}
