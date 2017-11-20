package model;


public class Feedback 
{
	private String name;
	private String email;
	private String date;
	private String feedback;
	
	public Feedback(String name, String email, String date, String feedback)
	{
		this.name  = name;
		this.email = email;
		this.date  = date;
		this.feedback = feedback;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public String getFeedback()
	{
		return this.feedback;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setFeedback(String feedback)
	{
		this.feedback = feedback;
	}
}
