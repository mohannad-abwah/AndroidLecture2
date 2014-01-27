package ca.uoftdev.androidui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent intent = getIntent();
		String text = intent.getStringExtra("text");
		TextView textView = (TextView) findViewById(R.id.second_text);
		textView.setText(text);
	}
	
	public void onDoneClick(View view) {
		finish();
	}
	
}
