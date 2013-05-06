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
public class AdminAddReservationInfoActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserveinfo);
        
        db = (DB)getIntent().getSerializableExtra("db");

        //set up buttons with their listeners
        View submitButton = findViewById(R.id.submit_button);
		submitButton.setOnClickListener(this);
		View backButton = findViewById(R.id.back_button);
		backButton.setOnClickListener(this);
    }
	public void onClick(View v)
	{
		EditText cinRestaurantName, cinRestaurantAddress, cinCustomerName, cinCustomerPhone;
		String restaurantName="", customerName="", restaurantAddress="";
		int customerPhone=0;
		TextView result=null;
		if (v.getId() == R.id.submit_button)
		{
			//check for valid data
			//redirect to time input if data valid
			//output error if not valid
			cinRestaurantName = (EditText)findViewById(R.id.cinRestaurantName_edittext);
			cinRestaurantName.clearFocus();
			cinRestaurantAddress = (EditText)findViewById(R.id.cinRestaurantAddress_edittext);
			cinRestaurantAddress.clearFocus();
			cinCustomerName = (EditText)findViewById(R.id.cinCustomerName_edittext);
			cinCustomerName.clearFocus();
			cinCustomerPhone = (EditText)findViewById(R.id.cinCustomerPhoneNumber_edittext);
			cinCustomerPhone.clearFocus();
			restaurantName = cinRestaurantName.getText().toString();
			restaurantAddress = cinRestaurantAddress.getText().toString();
			customerName = cinCustomerName.getText().toString();
			customerPhone = Integer.parseInt(cinCustomerPhone.getText().toString());
			if (customerName.equals("") || restaurantName.equals("") || restaurantAddress.equals("") || customerPhone==0)
			{
				result = (TextView)findViewById(R.id.result_textview);
				result.setText("The form is incomplete.");
			}
			else
			{
				//find if restaurant exists, if it does, add
				Restaurant temp = new Restaurant();
				temp.setName(restaurantName);
				temp.setAddress(restaurantAddress);
				Reservation reservation = new Reservation();
				reservation.setCustomerName(customerName);
				reservation.setCustomerPhoneNumber(customerPhone);
				if (db.getRestaurantList().contains(temp))
				{
					int capacity=0, reserved=0;
					capacity = db.getRestaurantList().get(db.getRestaurantList().indexOf(temp)).getTotalSeats();
					reserved = db.getRestaurantList().get(db.getRestaurantList().indexOf(temp)).getReservedSeats();
					if (reserved < capacity)
					{
						reserved++;
						db.getRestaurantList().get(db.getRestaurantList().indexOf(temp)).setReservedSeats(reserved);
						db.getReservationList().add(reservation);
						Intent intent = new Intent(this, ReserveTimeActivity.class);
						intent.putExtra("db", db);
						startActivity(intent);
						
					}
					else
					{
						result = (TextView)findViewById(R.id.result_textview);
						result.setText("Restaurant has reached capacity.");
					}
				}
				else
				{
					result = (TextView)findViewById(R.id.result_textview);
					result.setText("Restaurant does not exist.");
				}
			}
			
		}
		else if(v.getId() == R.id.back_button)
		{
			Intent intent = new Intent(this, MainActivity.class);
			intent.putExtra("db", db);
			startActivity(intent);
		}
    }
}
