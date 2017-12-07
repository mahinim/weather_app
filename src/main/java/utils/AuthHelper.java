package utils;

public class AuthHelper {
	
	public static boolean isAllowed(String login, String password) {		
		    return login.contentEquals("admin@example.com") && password.contentEquals("password");
	}

}
