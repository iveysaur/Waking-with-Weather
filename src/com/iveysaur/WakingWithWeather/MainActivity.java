package com.iveysaur.WakingWithWeather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void fileChooser(View v) {
		Intent i = new Intent(this,
				FileChooser.class);
		startActivityForResult(i, 1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		TextView fileName = (TextView)findViewById(R.id.file_choose_text);
		Bundle b = data.getExtras();

		if (b != null) {
			String name = (String) b.get("file");
			fileName.setText(name);
		}
	}
}
