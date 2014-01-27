package ca.uoftdev.androidui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MySimpleAdapter extends BaseAdapter {
	
	private final String[] data = new String[]{"Hello", "World!", "How's", "it", "going?", "I'm", "doing", "great!", "Android", "is", "easy", "to", "learn!"};
	private int offset = 0;

	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override // optional (can change return type to any non-primitive Java type)
	public String getItem(int position) {
		int index = (position + offset) % data.length;
		return data[index];
	}

	@Override // optional
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// inflate view if necessary
		convertView = prepareView(convertView, parent);

		// fill it in with data
		TextView textView = (TextView) convertView.findViewById(R.id.list_item_text);
		String text = getItem(position);
		textView.setText(text);

		// return it
		return convertView;
	}

	private View prepareView(View convertView, ViewGroup parent) {
		if (convertView == null) {
			Context context = parent.getContext();
			LayoutInflater inflater = LayoutInflater.from(context);
			return inflater.inflate(R.layout.list_item, parent, false);
		} else {
			return convertView;
		}
	}

	public void skipOne() {
		offset++;
		notifyDataSetChanged();
	}

}
