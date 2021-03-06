package com.iveysaur.WakingWithWeather;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

public class FileChooser extends ListActivity
{
	private File curDir;
	private FileArrayAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.file_view);
		curDir = new File("/sdcard/");
		files(curDir);
    }

	private void files(File f) {
		File[]dirs = f.listFiles();

		this.setTitle("Current Dir: " + f.getName());
		List<Option>dir = new ArrayList<Option>();
		List<Option>files = new ArrayList<Option>();

		try {
			for (File ff: dirs) {
				if (ff.isDirectory()) {
					dir.add(new Option(ff.getName(), "Folder", ff.getAbsolutePath()));
				} else {
					files.add(new Option(ff.getName(), "File Size: " + ff.length(), ff.getAbsolutePath()));
				}
			}
		} catch(Exception e) {
		}

		Collections.sort(dir);
		Collections.sort(files);

		dir.addAll(files);

		if (!f.getName().equalsIgnoreCase("sdcard")) {
			dir.add(0, new Option("...", "Parent Directory", f.getParent()));
		}
		adapter = new FileArrayAdapter(FileChooser.this, R.layout.file_view, dir);
		this.setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Option o = adapter.getItem(position);

		if (o.getData().equalsIgnoreCase("folder") || o.getData().equalsIgnoreCase("parent directory")) {
			curDir = new File(o.getPath());
			files(curDir);
		} else {
			onFileClick(o);
		}
	}

	private void onFileClick(Option o) {
		Intent i = new Intent(this,
				MainActivity.class);
		i.putExtra("file", o.getName());
		setResult(1, i);
		finish();
	}
}
