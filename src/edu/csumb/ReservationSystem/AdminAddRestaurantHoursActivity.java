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
public class AdminAddRestaurantHoursActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputrestauranthours);
        
        db = (DB)getIntent().getSerializableExtra("db");

        //set up buttons with their listeners
        View submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
        View backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		TimePicker cinOpen, cinClosed;
		int openHour, openMin, closedHour, closedMin;
		TextView result = null;
		Intent intent = null;
		if(v.getId() == R.id.submit_button)
		{	
			//this block of data must be verified for input
			cinOpen = (TimePicker)findViewById(R.id.cinRestaurantOpen_timepicker);
			cinOpen.clearFocus();
			cinClosed = (TimePicker)findViewById(R.id.cinRestaurantClose_timepicker);
			cinClosed.clearFocus();
			openHour = cinOpen.getCurrentHour();
			openMin = cinOpen.getCurrentMinute();
			closedHour = cinClosed.getCurrentHour();
			closedMin = cinClosed.getCurrentMinute();
	
			if ((openHour == closedHour && openMin < closedMin) ||  (openHour < closedHour))
			{
				//data is valid so input to db
				Restaurant temp = db.getRestaurantList().get(db.getRestaurantList().size()-1);
				temp.setOpenHour(openHour);
				temp.setOpenMin(openMin);
				temp.setCloseHour(closedHour);
				temp.setCloseMin(closedMin);
				intent = new Intent(this, RestaurantSuccessActivity.class);
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
			intent = new Intent(this, AdminAddRestaurantActivity.class);
			intent.putExtra("db", db);
			startActivity(intent);
		}
    }
}
