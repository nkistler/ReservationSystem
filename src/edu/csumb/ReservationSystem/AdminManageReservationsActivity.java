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
public class AdminManageReservationsActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managereservations);
        
        db = (DB)getIntent().getSerializableExtra("db");

        //set up buttons with their listeners
		View addReservationsButton = findViewById(R.id.addReservations_button);
		addReservationsButton.setOnClickListener(this);
		View deleteResevationsButton = findViewById(R.id.deleteReservations_button);
        deleteResevationsButton.setOnClickListener(this);
		View backButton = findViewById(R.id.back_button);
		backButton.setOnClickListener(this);
		View homeButton = findViewById(R.id.home_button);
		homeButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		Intent intent = null;
		if (v.getId() == R.id.addReservations_button)
		{
			//redirect to add reservation page
			//intent = new Intent(this, AdminChooseRestaurantOptionActivity.class);
		}
		else if (v.getId() == R.id.deleteReservations_button)
		{
			//redirect to delete reservation page
			//intent = new Intent(this, AdminManageReservationsActivity.class);
		}
		else if (v.getId() == R.id.back_button)
		{
			intent = new Intent(this, AdminOptionActivity.class);
		}
		else if (v.getId() == R.id.home_button)
		{
			intent = new Intent(this, MainActivity.class);
		}
		intent.putExtra("db", db);
		startActivity(intent);
    }
}
