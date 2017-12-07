package controller.commands;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;

import model.WeatherUser;

public class RegisterCommand extends FrontCommand 
{
	private final static String DB_NAME = "weather";
	private static EntityManagerFactory factory;
	
	@Override
	public void process() throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory(DB_NAME);
		EntityManager em = factory.createEntityManager();
		
		String name = this.request.getParameter("name");
		String lastName = this.request.getParameter("lastName");
		String gender   = this.request.getParameter("gender");
		String birth_date = this.request.getParameter("birth_date");
		String password  = this.request.getParameter("password");
		String email    = this.request.getParameter("email");
		
		em.getTransaction().begin();
		
		WeatherUser weatherUser = new WeatherUser(email,password);
		em.persist(weatherUser);
		em.getTransaction().commit();
		
		this.response.getWriter().println("Регистрация прошла успешно");
	}
	

}
