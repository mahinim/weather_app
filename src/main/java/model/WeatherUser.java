package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WeatherUser implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 541259005323929685L;
	
	private String username;
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int USER_ID;
	
	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	// empty constructor
	public WeatherUser(){
		
	};
 
	// constructor with parameters
	public WeatherUser(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	
	// Mapping to the Feedback
	@OneToMany(mappedBy = "weatherUser")
	private final java.util.List<UserFeedback> feedbacks = new ArrayList<UserFeedback>();
	
	// get all Feedback messages of a certain user 
	public java.util.List<UserFeedback> getFeedbacks() {
		return feedbacks;
	}
	
	
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}

}
