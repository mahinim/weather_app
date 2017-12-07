package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserFeedback implements Serializable
{
	private String name;
	private String email;
	private String date;
	private String feedback;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int FeedBack_ID;
	
	public WeatherUser getUser() {
		return weatherUser;
	}

	public void setUser(WeatherUser user) {
		this.weatherUser = user;
	}

	@ManyToOne(cascade=CascadeType.PERSIST)
	private WeatherUser weatherUser;
	
	public int getFEEDBACK_ID() {
		return this.FeedBack_ID;
	}

	public void setFEEDBACK_ID(int fEEDBACK_ID) {
		this.FeedBack_ID = fEEDBACK_ID;
	}

	public UserFeedback(String name, String email, String date, String feedback, WeatherUser weatherUser)
	{
		this.name  = name;
		this.email = email;
		this.date  = date;
		this.feedback = feedback;
		this.weatherUser = weatherUser;
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
