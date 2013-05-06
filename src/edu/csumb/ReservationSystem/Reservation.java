package edu.csumb.ReservationSystem;

import java.io.Serializable;

@SuppressWarnings("serial") 
public class Reservation implements Serializable
{
	private int timeHour;
	private int timeMin;
	private Restaurant restaurant;
	private String customerName;
	private int customerPhoneNumber;
	
	public Reservation()
	{
		this.timeHour=0;
		this.timeMin=0;
		this.restaurant=null;
		this.customerName="";
		this.customerPhoneNumber=0;
	}
	
	public boolean equals(Object r)
	{
		Reservation temp = (Reservation)r;
	    if (this.getCustomerName().equals(temp.getCustomerName()) && this.getCustomerPhoneNumber()==temp.getCustomerPhoneNumber() && this.getRestaurant().equals(temp.getRestaurant()))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
	
	//getters and setters
	public int getTimeHour()
	{
		return timeHour;
	}
	public void setTimeHour(int timeHour)
	{
		this.timeHour = timeHour;
	}
	public int getTimeMin()
	{
		return timeMin;
	}
	public void setTimeMin(int timeMin)
	{
		this.timeMin = timeMin;
	}
	public Restaurant getRestaurant()
	{
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	public int getCustomerPhoneNumber()
	{
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(int customerPhoneNumber)
	{
		this.customerPhoneNumber = customerPhoneNumber;
	}
}
