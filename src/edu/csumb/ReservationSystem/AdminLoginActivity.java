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
public class AdminLoginActivity extends Activity implements OnClickListener
{
	private DB db;
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administration);

        db = (DB)getIntent().getSerializableExtra("db");
        
        //set up buttons with their listeners
        View submitButton = findViewById(R.id.submit_button);
		submitButton.setOnClickListener(this);
		View backButton = findViewById(R.id.back_button);
		backButton.setOnClickListener(this);
		
		
    }
	public void onClick(View v)
    {
		EditText cinHandle, cinPassword;
		String handle, password;
		TextView result = null;
		if (v.getId() == R.id.submit_button)
		{
			cinHandle = (EditText)findViewById(R.id.cinput_adminhandle);
			cinPassword = (EditText)findViewById(R.id.cinput_adminpassword);
			handle = cinHandle.getText().toString();
			password = cinPassword.getText().toString();
			if (handle.equals("admin") && password.equals("password"))
			{
				//redirect to restaurant add/delete page
				Intent intent = new Intent(this, AdminOptionActivity.class);
				startActivity(intent);
			}
			else if (handle.equals("admin") && !password.equals("password"))
			{
				result = (TextView)findViewById(R.id.result_textview);
				result.setText("The password entered is incorrect.");
			}
			else
			{
				result = (TextView)findViewById(R.id.result_textview);
				result.setText("User not recognized.");
			}
		}
		else if(v.getId() == R.id.back_button)
		{
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}
	}
}
