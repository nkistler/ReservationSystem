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
		//initialize objects
		restaurantList = new ArrayList<Restaurant>();
		reservationList = new ArrayList<Reservation>();
		
		//populate with data
		Restaurant temp1 = new Restaurant();
		temp1.setName("McDonalds");
		temp1.setAddress("267 Reservation Rd, Marina, CA 93933");
		temp1.setTotalSeats(30);
		temp1.setOpenHour(6);
		temp1.setOpenMin(0);
		temp1.setCloseHour(22);
		temp1.setCloseMin(0);
		restaurantList.add(temp1);
		Restaurant temp2 = new Restaurant();
		temp2.setName("Chef Hannes");
		temp2.setAddress("411 Main St, El Segundo, CA 90245");
		temp2.setTotalSeats(15);
		temp2.setOpenHour(11);
		temp2.setOpenMin(0);
		temp2.setCloseHour(23);
		temp2.setCloseMin(59);
		restaurantList.add(temp2);
		Restaurant temp3 = new Restaurant();
		temp3.setName("Mama Ds");
		temp3.setAddress("1125 Manhattan Ave, Manhattan Beach, CA 90266");
		temp3.setTotalSeats(25);
		temp3.setOpenHour(11);
		temp3.setOpenMin(30);
		temp3.setCloseHour(23);
		temp3.setCloseMin(59);
		restaurantList.add(temp3);
		Restaurant temp4 = new Restaurant();
		temp4.setName("Pho Kimmy");
		temp4.setAddress("14932 Bushard St, Westminster, CA 92683");
		temp4.setTotalSeats(10);
		temp4.setOpenHour(12);
		temp4.setOpenMin(0);
		temp4.setCloseHour(21);
		temp4.setCloseMin(0);
		restaurantList.add(temp4);
		Reservation tempA = new Reservation();
		tempA.setCustomerName("Abraham Lincoln");
		tempA.setCustomerPhoneNumber(213856);
		tempA.setRestaurant(temp2);
		tempA.setTimeHour(18);
		tempA.setTimeMin(0);
		reservationList.add(tempA);
		Reservation tempB = new Reservation();
		tempB.setCustomerName("George Washington");
		tempB.setCustomerPhoneNumber(5668765);
		tempB.setRestaurant(temp4);
		tempB.setTimeHour(12);
		tempB.setTimeMin(30);
		reservationList.add(tempB);
		Reservation tempC = new Reservation();
		tempC.setCustomerName("Theodore Roosevelt");
		tempC.setCustomerPhoneNumber(8764533);
		tempC.setRestaurant(temp3);
		tempC.setTimeHour(21);
		tempC.setTimeMin(00);
		reservationList.add(tempC);
		Reservation tempD = new Reservation();
		tempD.setCustomerName("George W. Bush");
		tempD.setCustomerPhoneNumber(8973426);
		tempD.setRestaurant(temp1);
		tempD.setTimeHour(13);
		tempD.setTimeMin(00);
		reservationList.add(tempD);
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
}
