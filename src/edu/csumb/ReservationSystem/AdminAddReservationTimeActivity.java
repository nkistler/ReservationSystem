/**
 * 
 */
package edu.csumb.ReservationSystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * @author Nathan
 *
 */
public class AdminAddReservationTimeActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservetime);
        
        db = (DB)getIntent().getSerializableExtra("db");

        //set up buttons with their listeners
        View submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
        View backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		TextView result;
		TimePicker cinTime;
		int hour, minute, openMin, openHour, closeMin, closeHour;
		Intent intent = null;
		if(v.getId() == R.id.submit_button)
		{	
			//this block of data must be verified for input
			cinTime = (TimePicker)findViewById(R.id.cinReservationTime_timepicker);
			cinTime.clearFocus();
			hour = cinTime.getCurrentHour();
			minute = cinTime.getCurrentMinute();
			openHour = db.getReservationList().get(db.getReservationList().size()-1).getRestaurant().getOpenHour();
			openMin = db.getReservationList().get(db.getReservationList().size()-1).getRestaurant().getOpenMin();
			closeHour = db.getReservationList().get(db.getReservationList().size()-1).getRestaurant().getCloseHour();
			closeMin = db.getReservationList().get(db.getReservationList().size()-1).getRestaurant().getCloseMin();
			if ((hour >= openHour && minute > openMin) && (hour <= closeHour && minute < closeMin))//check if hours are valid
			{
				//data is valid so input to db
				Reservation temp = db.getReservationList().get(db.getReservationList().size()-1);
				temp.setTimeHour(hour);
				temp.setTimeMin(minute);
				intent = new Intent(this, ReservationSuccessActivity.class);
				intent.putExtra("db", db);
				startActivity(intent);
			}
			else
			{
				//output error message
				result = (TextView)findViewById(R.id.result_textview);
				result.setText("The hours entered are invalid.");
			}
		}
		else if(v.getId() == R.id.back_button)
		{
			intent = new Intent(this, AdminAddRestaurantInfoActivity.class);
			intent.putExtra("db", db);
			startActivity(intent);
		}
    }
}
