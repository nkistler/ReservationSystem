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
		Restaurant temp1 = new Restaurant();
		temp1.setName("McDonalds");
		temp1.setAddress("267 Reservation Rd, Marina, CA 93933");
		restaurantList.add(temp1);
		Restaurant temp2 = new Restaurant();
		temp2.setName("Chef Hannes");
		temp2.setAddress("411 Main St, El Segundo, CA 90245");
		restaurantList.add(temp2);
		Restaurant temp3 = new Restaurant();
		temp3.setName("Mama Ds");
		temp3.setAddress("1125 Manhattan Ave, Manhattan Beach, CA 90266");
		restaurantList.add(temp3);
		Restaurant temp4 = new Restaurant();
		temp4.setName("Pho Kimmy");
		temp4.setAddress("14932 Bushard St, Westminster, CA 92683");
		restaurantList.add(temp4);
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
