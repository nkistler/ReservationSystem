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
public class ReserveActivity extends Activity implements OnClickListener
{
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve);

        //set up buttons with their listeners
		View backButton = findViewById(R.id.back_button);
		backButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		if(v.getId() == R.id.back_button)
		{
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}
	}
}
