package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 541259005323929685L;
	
	private String username;
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int USER_ID;
	
	// empty constructor
	public User(){
		
	};
 
	// constructor with parameters
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
 
	// Mapping to the Feedback
	@OneToMany(mappedBy = "user")
	private final java.util.List<Feedback> feedbacks = new ArrayList<Feedback>();
	
	// get all Feedback messages of a certain user 
	public java.util.List<Feedback> getFeedbacks() {
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
