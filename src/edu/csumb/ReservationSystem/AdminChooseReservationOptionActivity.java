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
public class AdminChooseReservationOptionActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservationoption);
        
        db = (DB)getIntent().getSerializableExtra("db");

        //set up buttons with their listeners
        View addReservationButton = findViewById(R.id.addreservation_button);
        addReservationButton.setOnClickListener(this);
		View deleteReservationButton = findViewById(R.id.deletereservation_button);
		deleteReservationButton.setOnClickListener(this);
		View homeButton = findViewById(R.id.home_button);
		homeButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		Intent intent = null;
		if(v.getId() == R.id.addreservation_button)
		{
			intent = new Intent(this, AdminAddReservationInfoActivity.class);
		}
		else if(v.getId() == R.id.deletereservation_button)
		{
			intent = new Intent(this, AdminDeleteReservationActivity.class);
		}
		else if(v.getId() == R.id.back_button)
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
