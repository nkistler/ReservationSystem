package edu.csumb.ReservationSystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener
{
	//start database
	private DB db;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
        //grab db
        db = new DB();
        
        //set up buttons with their listeners
		View reserveButton = findViewById(R.id.reserve_button);
		reserveButton.setOnClickListener(this);
		View cancelButton = findViewById(R.id.cancel_button);
		cancelButton.setOnClickListener(this);
		View adminButton = findViewById(R.id.admin_button);
		adminButton.setOnClickListener(this);
    }
    
    public void onClick(View v)
    {
    	Intent intent = null;
    	if(v.getId() == R.id.reserve_button)
    	{
    		//reserve a table
    		intent = new Intent(this, ReserveInfoActivity.class);
    	}
    	else if (v.getId() == R.id.cancel_button)
    	{
    		//cancel existing reservation
    		intent = new Intent(this, CancelActivity.class);
    	}
    	else if (v.getId() == R.id.admin_button)
    	{
    		//add or delete restaurant info
    		intent = new Intent(this, AdminLoginActivity.class);
    	}
    	intent.putExtra("db", db);
    	startActivity(intent); 
	}
}