package com.iveysaur.WakingWithWeather;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void fileChoose(View v) {
		setContentView(R.layout.file_view);
	}
}
