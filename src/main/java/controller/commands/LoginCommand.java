package controller.commands;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import model.WeatherUser;
import utils.AuthHelper;

public class LoginCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		
		/*
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		*/
 
		if (AuthHelper.isAllowed(username, password)) {
			/*
			rd = request.getRequestDispatcher("/weather.html");
			User user = new User(username, password);
			request.setAttribute("user", user);
			HttpSession session=request.getSession();  
		    session.setAttribute("username", username);  
		    */
			
			/*
			request.getRequestDispatcher("link.html").include(request, response);
			out.print("Welcome, " + username); 
			*/ 
	        HttpSession session=request.getSession();  
	        session.setAttribute("name", username);
			
			
			forward("weather");
		} else {
			//rd = request.getRequestDispatcher("/registration.html");
			/*
			 out.print("Sorry, username or password error!");  
	         request.getRequestDispatcher("registration.html").include(request, response);
	         */
			forward("registration"); 
		}
		//rd.forward(request, response);
		
	}

}
