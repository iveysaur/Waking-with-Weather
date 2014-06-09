package com.iveysaur.WakingWithWeather;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity
{
	private File curDir;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		curDir = new File("/sdcard/");
        setContentView(R.layout.main);
    }

	private void files(File f) {
	}
}
