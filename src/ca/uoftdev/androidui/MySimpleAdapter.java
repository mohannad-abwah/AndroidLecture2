package ca.uoftdev.androidui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MySimpleAdapter extends BaseAdapter {
	
	private final String[] data = new String[]{"Hello", "World!", "How's", "it", "going?", "I'm", "doing", "great!", "Android", "is", "easy", "to", "learn!"};

	@Override
	public int getCount() {
		return data.length;
	}

	@Override // optional (can change return type to any non-primitive Java type)
	public String getItem(int position) {
		return data[position];
	}

	@Override // optional
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// inflate view
		Context context = parent.getContext();
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.list_item, parent, false);
		
		// fill it in with data
		TextView textView = (TextView) view.findViewById(R.id.list_item_text);
		String text = getItem(position);
		textView.setText(text);
		
		// return it
		return view;
	}

}
