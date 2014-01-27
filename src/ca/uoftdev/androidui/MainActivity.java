package ca.uoftdev.androidui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	private MySimpleAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView listView = (ListView) findViewById(R.id.list_view);
		Button skipOneButton = (Button) findViewById(R.id.btn_skip_one);

		this.adapter = new MySimpleAdapter();
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(onItemClickListener);
		skipOneButton.setOnClickListener(skipOnClickListener);
	}

	private final OnItemClickListener onItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent intent = new Intent(MainActivity.this, SecondActivity.class);
			String text = String.format("Position %d clicked!", position);
			intent.putExtra("text", text);
			startActivity(intent);
		}
	};

	private final OnClickListener skipOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View view) {
			adapter.skipOne();
		}
	};

}
