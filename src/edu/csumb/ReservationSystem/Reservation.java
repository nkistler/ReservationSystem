package edu.csumb.ReservationSystem;

import java.io.Serializable;

@SuppressWarnings("serial") 
public class Reservation implements Serializable
{
	private int time;
	private Restaurant restaurant;
	private String customerName;
	private int customerPhoneNumber;
	
	public Reservation()
	{
		this.time=0;
		this.restaurant=null;
		this.customerName="";
		this.customerPhoneNumber=0;
	}
	
	//getters and setters
	public int getTime()
	{
		return time;
	}
	public void setTime(int time)
	{
		this.time = time;
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
	public boolean equals(Reservation r)
	{
	    if (r.getCustomerName().equals(this.getCustomerName()) && r.getRestaurant().equals(this.getRestaurant()) && r.getTime() == this.getTime() && r.getCustomerPhoneNumber() == this.getCustomerPhoneNumber())
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
}
