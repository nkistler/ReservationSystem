package edu.csumb.ReservationSystem;

import android.text.format.Time;

public class Reservation
{
	private Time time;
	private Restaurant restaurant;
	private String customerName;
	private int customerPhoneNumber;
	public Time getTime()
	{
		return time;
	}
	public void setTime(long milliseconds)
	{
		this.time.set(milliseconds);
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
	    if (r.getCustomerName().equals(this.getCustomerName()) && r.getRestaurant().equals(this.getRestaurant()) && r.getTime().equals(this.getTime()) && r.getCustomerPhoneNumber() == this.getCustomerPhoneNumber())
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
}
