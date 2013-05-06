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
public class ReservationSuccessActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        
        db = (DB)getIntent().getSerializableExtra("db");

        //set up buttons with their listeners
        View submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
        View homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		Intent intent=null;
		if(v.getId() == R.id.submit_button)
		{
			intent = new Intent(this, AdminChooseReservationOptionActivity.class);
		}
		else if(v.getId() == R.id.home_button)
		{
			intent = new Intent(this, MainActivity.class);			
		}
		intent.putExtra("db", db);
		startActivity(intent);
    }
}
