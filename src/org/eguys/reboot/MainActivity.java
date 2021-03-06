package org.eguys.reboot;

import java.io.DataOutputStream;
import java.io.IOException;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			Process process = Runtime.getRuntime().exec("su");
			DataOutputStream outputStream = new DataOutputStream(
					process.getOutputStream());
			// DataInputStream inputStream = new DataInputStream(
			// process.getInputStream());

			outputStream.writeBytes("reboot" + "\n");
			outputStream.flush();
			// outputStream.writeBytes("exit\n");
			// outputStream.flush();
			// process.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
			// } catch (InterruptedException e) {
			// e.printStackTrace();
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId()){
		case R.id.action_settings : 
			android.os.Process.killProcess(android.os.Process.myPid());
			return true;
		case R.id.action_about : 
			// Intent intent = new Intent(this, AboutActivity.class);
			startActivity(new Intent(this, AboutActivity.class));
			return true;	
		}
		return super.onOptionsItemSelected(item);
	}
}
