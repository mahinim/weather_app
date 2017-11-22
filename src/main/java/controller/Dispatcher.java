package controller;

import view.AuthorizationView;
import view.WeatherView;

public class Dispatcher {
	
   private WeatherView weatherView;
   private AuthorizationView authView;
   
   public Dispatcher(){
      weatherView = new WeatherView();
      authView = new AuthorizationView();
   }

   public void dispatch(String request){
      if(request.equalsIgnoreCase("WEATHER")){
    	  weatherView.show();
      }
      else{
    	  authView.show();
      }	
   }

}
