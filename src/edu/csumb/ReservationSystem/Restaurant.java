package edu.csumb.ReservationSystem;

import java.io.Serializable;

@SuppressWarnings("serial") 
public class Restaurant implements Serializable
{
	private String name;
	private String address;
	private int totalSeats;
	private int reservedSeats;
	private int openHour;
	private int openMin;
	private int closeHour;
	private int closeMin;
	
	public Restaurant()
	{
		this.name="";
		this.address="";
		this.totalSeats=0;
		this.reservedSeats=0;
		this.openHour=0;
		this.openMin=0;
		this.closeHour=0;
		this.closeMin=0;
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
	public int getOpenHour()
	{
		return openHour;
	}
	public void setOpenHour(int openHour)
	{
		this.openHour = openHour;
	}
	public int getOpenMin()
	{
		return openMin;
	}
	public void setOpenMin(int openMin)
	{
		this.openMin = openMin;
	}
	public int getCloseHour()
	{
		return closeHour;
	}
	public void setCloseHour(int closeHour)
	{
		this.closeHour = closeHour;
	}
	public int getCloseMin()
	{
		return closeMin;
	}
	public void setCloseMin(int closeMin)
	{
		this.closeMin = closeMin;
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
