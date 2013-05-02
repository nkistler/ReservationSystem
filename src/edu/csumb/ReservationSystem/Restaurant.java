package edu.csumb.ReservationSystem;

import java.io.Serializable;

@SuppressWarnings("serial") 
public class Restaurant implements Serializable
{
	private String name;
	private String address;
	private int totalSeats;
	private int reservedSeats;
	private int timeOpen;
	private int timeClosed;
	
	public Restaurant()
	{
		this.name="";
		this.address="";
		this.totalSeats=0;
		this.reservedSeats=0;
		this.timeOpen=0;
		this.timeClosed=0;
	}
	
	//gettters and setters
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public int getTotalSeats()
	{
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats)
	{
		this.totalSeats = totalSeats;
	}
	public int getReservedSeats()
	{
		return reservedSeats;
	}
	public void setReservedSeats(int reservedSeats)
	{
		this.reservedSeats = reservedSeats;
	}
	public int getTimeOpen()
	{
		return timeOpen;
	}
	public void setTimeOpen(int timeOpen)
	{
		this.timeOpen = timeOpen;
	}
	public int getTimeClosed()
	{
		return timeClosed;
	}
	public void setTimeClosed(int timeClosed)
	{
		this.timeClosed = timeClosed;
	}
	public boolean equals(Restaurant r)
	{
	    if (r.getName().equals(this.getName()) && r.getAddress().equals(this.getAddress()))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
	
}
