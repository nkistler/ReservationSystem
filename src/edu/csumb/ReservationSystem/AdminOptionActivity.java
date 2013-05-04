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
public class AdminOptionActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage);
        
        db = (DB)getIntent().getSerializableExtra("db");

        //set up buttons with their listeners
        View restaurantsButton = findViewById(R.id.restaurants_button);
        restaurantsButton.setOnClickListener(this);
		View reservationsButton = findViewById(R.id.reservations_button);
		reservationsButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		Intent intent = null;
		if (v.getId() == R.id.restaurants_button)
		{
			intent = new Intent(this, AdminChooseRestaurantOptionActivity.class);
		}
		else if (v.getId() == R.id.reservations_button)
		{
			intent = new Intent(this, AdminManageReservationsActivity.class);
		}
		else if (v.getId() == R.id.home_button)
		{
			intent = new Intent(this, MainActivity.class);
		}
		intent.putExtra("db", db);
		startActivity(intent);
    }
}
