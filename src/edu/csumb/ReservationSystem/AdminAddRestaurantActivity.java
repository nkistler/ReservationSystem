/**
 * 
 */
package edu.csumb.ReservationSystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author Nathan
 *
 */
public class AdminAddRestaurantActivity extends Activity implements OnClickListener
{
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputrestaurant);

        //set up buttons with their listeners
        View submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
        View backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		Intent intent = null;
		if(v.getId() == R.id.submit_button)
		{
			//add new restaurant
		}
		else if(v.getId() == R.id.back_button)
		{
			intent = new Intent(this, AdminChooseRestaurantOptionActivity.class);
		}
		startActivity(intent);
    }
}
