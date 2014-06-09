package com.iveysaur.WakingWithWeather;

public class FileArrayAdapter extends ArrayAdapter<Option> {
	private Context c;
	private int id;
	private List<Option> items;

	public FileArrayAdapter(Context context, int textViewResourceId,
			List<Option> objects) {
		super(context, textViewResourceId, objects);
		c = context;
		id = textViewResourceId;
		items = objects;
	}

	public Option getItem(int i) {
		return items.get(i);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(id, null);
		}

		final Option o = items.get(position);

		if (o != null) {
			TextView t1 = (Textview) v.findViewById(R.id.TextView01);
			TextView t2 = (Textview) v.findViewById(R.id.TextView02);
			if (t1 != null) {
				t1.setText(o.getName());
			}
			if (t2 != null) {
				t2.setText(o.getName());
			}
		}
		return v;
	}
}

