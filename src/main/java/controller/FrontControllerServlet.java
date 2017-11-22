package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AuthHelper;
import model.User;
import controller.commands.FrontCommand;
import controller.commands.UnknownCommand;

public class FrontControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Dispatcher dispatcher;
	 
	public FrontControllerServlet() {
		super();
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
 
		//Authenticator authenticator = new Authenticator();
		//String result = authenticator.authenticate(username, password);
		if (AuthHelper.isAllowed(username, password)) {
			rd = request.getRequestDispatcher("/weather.html");
			User user = new User(username, password);
			request.setAttribute("user", user);
		} else {
			rd = request.getRequestDispatcher("/registration.html");
		}
		rd.forward(request, response);
	}
	
    /*
	@Override
    protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) {
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        try {
			command.process();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    protected void doPost(HttpServletRequest request, 
      HttpServletResponse response) {
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        try {
			command.process();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
 
    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            Class type = Class.forName(String.format("controller.commands.%sCommand", request.getParameter("command")));
            return (FrontCommand) type.asSubclass(FrontCommand.class).newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }
    */
}
