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
public class AdminDeleteRestaurantActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removerestaurant);
        
        db = (DB)getIntent().getSerializableExtra("db");

        //set up buttons with their listeners
        View submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);
        View backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
    }
	public void onClick(View v)
    {
		EditText cinName, cinAddress;
		String name, address;
		TextView result = null;
		Intent intent = null;
		if(v.getId() == R.id.submit_button)
		{
			//search for restaurant
			//delete if found
			//report if not found
			cinName = (EditText)findViewById(R.id.cinRestaurantName_edittext);
			cinAddress = (EditText)findViewById(R.id.cinRestaurantAddress_edittext);
			name = cinName.getText().toString();
			address = cinAddress.getText().toString();
			Restaurant temp = new Restaurant();
			temp.setName(name);
			temp.setAddress(address);
			result = (TextView)findViewById(R.id.result_textview);
			if (name.equals("") || address.equals(""))
			{
				result.setText("The form is incomplete.");
			}
			else if (db.getRestaurantList().contains(temp)) //this branch deletes the element
			{
				result.setText(db.getRestaurantList().get(db.getRestaurantList().indexOf(temp)).getName() + " has been removed.");
				db.getRestaurantList().remove(temp);
			}
			else
			{
				result.setText("No matching restaurants found.");
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
