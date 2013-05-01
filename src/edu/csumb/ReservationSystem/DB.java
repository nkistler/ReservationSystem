package edu.csumb.ReservationSystem;

import java.util.ArrayList;

public class DB
{
	private ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	
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
