package model;


public class Weather 
{
	private int maxTemp;
	private int minTemp;
	private String weatherType;
	private String day;
	private int date;
	private String month;
	
	public Weather(int maxTemp, int minTemp, String weatherType,String day,int date,String month)
	{
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.weatherType = weatherType;
		this.day 		 = day;
		this.date 		 = date;
		this.month		 = month;
	}
	
	public int getMaxTemp()
	{
		return this.maxTemp;
	}
	
	public int getMinTemp()
	{
		return this.minTemp;
	}
	
	public String getWeatherType()
	{
		return this.weatherType;
	}	
	
	public String getDay()
	{
		return this.day;
	}
	
	public int getDate()
	{
		return this.date;		
	}
	
	public String getMonth()
	{
		return this.month;
	}
	
	public void setMaxTemp(int maxTemp)
	{
		this.maxTemp = maxTemp;
	}
	
	public void setMinTemp(int minTemp)
	{
		this.minTemp=minTemp;	
	}
	
	public void setWeatherType(String weathertype)
	{
		this.weatherType=weathertype;
	}
	
	public void setDay(String Day)
	{
		this.day=Day;
	}
	
	public void setDate(int Date)
	{
		this.date=Date;
	}
	
	public void setMonth(String month)
	{
		this.month=month;
	}
	
	@Override
	public String toString()
	{
		return "day = "+this.day+"; date = "+this.date+"; month= "+this.month+"; minTemp = "
				+this.minTemp+"; maxTemp = "+this.maxTemp+"; weatherType = "+this.weatherType;
	}
}
