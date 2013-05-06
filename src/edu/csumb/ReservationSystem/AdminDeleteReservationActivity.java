/**
 * 
 */
package edu.csumb.ReservationSystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Nathan
 *
 */
public class AdminDeleteReservationActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removereservation);
        
        db = (DB)getIntent().getSerializableExtra("db");

        //set up buttons with their listeners
        View submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
        View backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		EditText cinRestaurantName, cinAddress, cinCustomerName, cinPhone;
		String restaurantName, address, customerName;
		int phone;
		TextView result = null;
		if(v.getId() == R.id.submit_button)
		{
			cinRestaurantName = (EditText)findViewById(R.id.cinRestaurantName_edittext);
			cinAddress = (EditText)findViewById(R.id.cinRestaurantAddress_edittext);
			cinCustomerName = (EditText)findViewById(R.id.cinCustomerName_edittext);
			cinPhone = (EditText)findViewById(R.id.cinCustomerPhoneNumber_edittext);
			restaurantName = cinRestaurantName.getText().toString();
			address = cinAddress.getText().toString();
			customerName = cinCustomerName.getText().toString();
			phone = Integer.parseInt(cinPhone.getText().toString());
			Restaurant temp = new Restaurant();
			temp.setName(restaurantName);
			temp.setAddress(address);
			Reservation reservation = new Reservation();
			reservation.setCustomerName(customerName);
			reservation.setCustomerPhoneNumber(phone);
			reservation.setRestaurant(temp);
			result = (TextView)findViewById(R.id.result_textview);
			if (restaurantName.equals("") || address.equals("") || customerName.equals("") || phone==0)
			{
				result.setText("The form is incomplete.");
			}
			else if (db.getReservationList().contains(reservation)) //this branch deletes the element
			{
				int numberOfReservations;
				numberOfReservations = db.getReservationList().get(db.getReservationList().indexOf(reservation)).getRestaurant().getReservedSeats();
				numberOfReservations--;
				db.getReservationList().get(db.getReservationList().indexOf(reservation)).getRestaurant().setReservedSeats(numberOfReservations);
				result.setText(db.getReservationList().get(db.getReservationList().indexOf(reservation)).getCustomerName() + "'s reservation has been removed.");
				db.getReservationList().remove(reservation);
			}
			else
			{
				result.setText("No matching reservations found.");
			}
		}
		else if(v.getId() == R.id.back_button)
		{
			Intent intent = new Intent(this, AdminChooseReservationOptionActivity.class);
			intent.putExtra("db", db);
			startActivity(intent);
		}
    }
}
