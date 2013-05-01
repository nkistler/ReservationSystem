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
public class AdminChooseRestaurantOptionActivity extends Activity implements OnClickListener
{
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurantoption);

        //set up buttons with their listeners
        View addRestaurantsButton = findViewById(R.id.addrestaurants_button);
        addRestaurantsButton.setOnClickListener(this);
		View deleteRestaurantsButton = findViewById(R.id.deleterestaurants_button);
		deleteRestaurantsButton.setOnClickListener(this);
		View backButton = findViewById(R.id.back_button);
		backButton.setOnClickListener(this);
		View homeButton = findViewById(R.id.home_button);
		homeButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		Intent intent = null;
		if(v.getId() == R.id.addrestaurants_button)
		{
			intent = new Intent(this, AdminAddRestaurantActivity.class);
		}
		else if(v.getId() == R.id.addrestaurants_button)
		{
			intent = new Intent(this, AdminDeleteRestaurantActivity.class);
		}
		else if(v.getId() == R.id.back_button)
		{
			intent = new Intent(this, AdminOptionActivity.class);
		}
		else if (v.getId() == R.id.home_button)
		{
			intent = new Intent(this, MainActivity.class);
		}
		startActivity(intent);
	}
}
