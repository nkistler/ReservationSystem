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
public class AdminAddRestaurantInfoActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputrestaurant);
        
        db = (DB)getIntent().getSerializableExtra("db");

        //set up buttons with their listeners
        View submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
        View backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		EditText cinName, cinAddress, cinCapacity;
		String name, address;
		int capacity;
		TextView result = null;
		Intent intent = null;
		if(v.getId() == R.id.submit_button)
		{
			//this block of data must be verified for input
			cinName = (EditText)findViewById(R.id.cinRestaurantName_edittext);
			cinAddress = (EditText)findViewById(R.id.cinRestaurantAddress_edittext);
			cinCapacity = (EditText)findViewById(R.id.cinRestaurantCapacity_edittext);
			name = cinName.getText().toString();
			address = cinAddress.getText().toString();
			capacity = Integer.parseInt(cinCapacity.getText().toString());
			if (!name.equals("") && !address.equals("") && capacity > 0)
			{
				//data is valid so input to db
				Restaurant temp = new Restaurant();
				temp.setName(name);
				temp.setAddress(address);
				temp.setTotalSeats(capacity);
				db.getRestaurantList().add(temp);
				intent = new Intent(this, AdminAddRestaurantHoursActivity.class);
				intent.putExtra("db", db);
				startActivity(intent);
			}
			else if (name.equals("") || address.equals("") || capacity > 0)
			{
				//output error message
				result = (TextView)findViewById(R.id.result_textview);
				result.setText("The form is incomplete.");
			}
		}
		else if(v.getId() == R.id.back_button)
		{
			intent = new Intent(this, AdminChooseRestaurantOptionActivity.class);
			intent.putExtra("db", db);
			startActivity(intent);
		}
    }
}
