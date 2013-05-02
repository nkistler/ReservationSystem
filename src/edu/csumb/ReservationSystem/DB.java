package edu.csumb.ReservationSystem;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial") 
public class DB implements Serializable
{
	private ArrayList<Restaurant> restaurantList;
	private ArrayList<Reservation> reservationList;
	
	public DB()
	{
		restaurantList = new ArrayList<Restaurant>();
		reservationList = new ArrayList<Reservation>();
		Restaurant temp = new Restaurant();
		temp.setName("McDonalds");
		restaurantList.add(temp);
	}
    
    //getters and setters below
	public ArrayList<Restaurant> getRestaurantList()
	{
		return restaurantList;
	}
	public void setRestaurantList(ArrayList<Restaurant> restaurantList)
	{
		this.restaurantList = restaurantList;
	}
	public ArrayList<Reservation> getReservationList()
	{
		return reservationList;
	}
	public void setReservationList(ArrayList<Reservation> reservationList)
	{
		this.reservationList = reservationList;
	}
	public void add(Restaurant restaurant)
	{
		this.restaurantList.add(restaurant);
	}
	public void add(Reservation reservation)
	{
		this.reservationList.add(reservation);
	}
	public boolean delete(Restaurant restaurant)
	{
		return this.restaurantList.remove(restaurant);
	}
	public boolean delete(Reservation reservation)
	{
		return this.reservationList.remove(reservation);
	}
}
