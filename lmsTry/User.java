package lmsTry;

public class User {
	private String id;
	private String lastName;
	private String firstName;
	private String password;
	private String userType;
	
	public User(String id, String lastName, String firstName, String password, String userType) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
		this.userType = userType;
	}
	
	// Getter Methods
	public String getId(){return id;}
	public String getLastName(){return lastName;}
	public String getFirstName(){return firstName;}
	public String getPassword(){return password;}
	public String getUserType(){return userType;}
	
	// Setter Methods
	public void setId(String id)				{this.id = id;}
	public void setLastName(String lastName)	{this.lastName = lastName;}
	public void setFirstName(String firstName)	{this.firstName = firstName;}
	public void setPassword(String password)	{this.password = password;}
	public void setUserType(String userType)	{this.userType = userType;}
}
