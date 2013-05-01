package edu.csumb.ReservationSystem;

import android.text.format.Time;

public class Restaurant
{
	private String name;
	private String address;
	private int totalSeats;
	private int reservedSeats;
	private Time timeOpen;
	private Time timeClosed;
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
	public Time getTimeOpen()
	{
		return timeOpen;
	}
	public void setTimeOpen(long milliseconds)
	{
		this.timeOpen.set(milliseconds);
	}
	public Time getTimeClosed()
	{
		return timeClosed;
	}
	public void setTimeClosed(long milliseconds)
	{
		this.timeClosed.set(milliseconds);
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
