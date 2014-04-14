package com.nanwu.ht;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.nanwu.ht.bean.WordListBean;
import com.nanwu.ht.common.DBUtil;

public class PlayMp3Activity extends Activity implements OnGestureListener{

	private static MediaPlayer mediaPlayer;
	private List<WordListBean> wordsList = null;
	private int i = 1;
	private int j = 1;
	private String text;
	private TextView textView;
	private ViewFlipper flipper;
	private GestureDetector detector;
	private Handler handler;
	private Runnable runnable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DBUtil db = new DBUtil(getApplicationContext());
		this.wordsList = db.query("", "");
		setContentView(R.layout.activity_play_mp3);
		textView = (TextView) findViewById(R.id.mp3_content);
		detector = new GestureDetector(this);
		flipper = (ViewFlipper) this.findViewById(R.id.ViewFlipper01);
		handler = new Handler();
		initRunnable();
		textInit();
		mediaPlayer = new MediaPlayer();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// Toast.makeText(PlayMp3Activity.this,"11",Toast.LENGTH_SHORT).show();
				if (i < wordsList.size() - 1) {
					play();
				}
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
		handler.removeCallbacks(runnable);
	}
	
	private void textInit(){
		text = "";
		text = text + "单词\n" + wordsList.get(i).getWord() + "\n\n";
		text = text + "拼写\n" + wordsList.get(i).getSpell() + "\n\n";
		text = text + "例えば\n" + wordsList.get(i).getMeaning().replace("\\n", "\n");
		textView.setText(text);
	}
	
	private void stop() {
		textInit();
		handler.removeCallbacks(runnable);
		mediaPlayer.stop();
		j = 1;
	}

	private void initRunnable() {
		runnable = new Runnable() {

			@Override
			public void run() {
				try {
					final String mp3File = "/mnt/sdcard/downloads/n2_word/" + wordsList.get(i).getId() + ".mp3";

					j = j * (-1);
					mediaPlayer.reset();
					textInit();

					mediaPlayer.setDataSource(mp3File);
					if (j > 0) {
						++i;
					}
					mediaPlayer.prepare();
					mediaPlayer.start();
				} catch (Exception e) {
					Log.e("fileExist", "music file does not exsit or file is empty! file's index:" + wordsList.get(i).getId());
					++i;
					if (i < wordsList.size() - 1) {
						play();
					}
				} finally {
				}
			}
		};
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {
		case R.id.menu_word:
			intent = new Intent(getApplicationContext(), RemWordsActivity.class);
			startActivity(intent);
			return true;
		case R.id.menu_listen:
			intent = new Intent(getApplicationContext(), PlayMp3Activity.class);
			startActivity(intent);
			return true;
		default:
			finish();
			return true;
		}
	}
	
	private void play() {
		handler.postDelayed(runnable, 800);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return this.detector.onTouchEvent(event);
	}
	
	@Override
    public boolean onDown(MotionEvent arg0) {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if (e1.getX() - e2.getX() > 120) {
			--i;
			stop();
			return true;
		} else if (e1.getX() - e2.getX() < -120) {
			play();
			return true;
		}
		return false;
	}


	@Override
    public void onLongPress(MotionEvent e) {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public void onShowPress(MotionEvent e) {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public boolean onSingleTapUp(MotionEvent e) {
	    // TODO Auto-generated method stub
	    return false;
    }
}
