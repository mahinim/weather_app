package utils;

import java.io.IOException;
import java.util.*;

import model.Weather;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class WeatherUtil 
{
	private static final String URL = 
			"https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D0%B7%D0%B0%D0%BF%D0%BE%D1%80%D0%BE%D0%B6%D1%8C%D0%B5";
	
	public static List<Weather> getWeather() throws IOException
	{
		ArrayList<Weather> weather = new ArrayList<Weather>();
		
		Document doc = Jsoup.connect(WeatherUtil.URL).get();
		
		for(int i = 1; i<=7;i++)
		{
			String day = "";
			String month = "";
			int    date = 0;
			int    minTemp = 0;
			int    maxTemp = 0;
			String weatherType ="";
			
			Element content = doc.getElementById("bd"+i);
			Elements links = content.getElementsByTag("p");
			
			int j = 0;
			for(Element link : links)
			{
				if(j == 0)
				{
					day = link.text();
				}
				else if(j == 1)
				{
					date = Integer.parseInt(link.text());
				}
				else if(j == 2)
				{
					month = link.text();
				}
				j++;
			}
			
			
			links = content.child(4).getElementsByTag("div");
			for(Element link: links)
			{
				if(link.className().equals("min"))
				{
					String[] text = link.text().split(" ");
					minTemp = Integer.parseInt(text[1].substring(0, 2));
				}
				else
				{
		 			String[] text = link.text().split(" ");
					maxTemp = Integer.parseInt(text[1].substring(0, 2));
				}
			}
			
			String weather_type = content.child(3).className();
			if(weather_type.equals("weatherIco d430"))
			{
				weatherType = "weather_5";
			}
			else if(weather_type.equals("weatherIco d320"))
			{
				weatherType = "weather_6";
			}
			else if(weather_type.equals("weatherIco d211"))
			{
				weatherType = "weather_11";
			}
			else if(weather_type.equals("weatherIco d300"))
			{
				weatherType = "weather_3";
			}
			else if(weather_type.equals("weatherIco d400"))
			{
				weatherType = "weather_4";
			}
			else if(weather_type.equals("weatherIco d000"))
			{
				weatherType = "weather_1";
			}
			else if(weather_type.equals("weatherIco d100"))
			{
				weatherType = "weather_2";
			}
			else if(weather_type.equals("weatherIco d412"))
			{
				weatherType = "weather_9";
			}
			else
			{
				weatherType = "weather_4";
			}
			
			weather.add(new Weather(maxTemp,minTemp,weatherType,day,date,month));
		}
		return weather;
	}
	
	public static void main(String[] args)
	{
		try {
			List<Weather> weather = getWeather();
			
			for(int i = 0; i<weather.size();i++)
			{
				System.out.println(weather.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
