package com.nanwu.ht;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowContentActivity extends Activity {
	
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrollview);
		textView = (TextView)findViewById(R.id.content);
		Intent wordInfo = getIntent();
		String[] getPara = wordInfo.getStringArrayExtra("wordInfo");
		textView.append("单词\n" + getPara[1] +"\n\n");
		textView.append("拼写\n"+  getPara[0]+"\n\n");
		textView.append("例えば\n"+  getPara[2].replace("\\n", "\n"));
	}
}
