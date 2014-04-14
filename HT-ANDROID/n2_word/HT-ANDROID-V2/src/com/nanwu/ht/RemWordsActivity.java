package com.nanwu.ht;

import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import com.nanwu.ht.bean.WordListBean;
import com.nanwu.ht.common.DBUtil;
import com.nanwu.ht.common.SwipeDismissListView;
import com.nanwu.ht.common.SwipeDismissListView.OnDismissCallback;

public class RemWordsActivity extends Activity {
	private SwipeDismissListView swipeDismissListView;
	private ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);

		Tab tab = actionBar.newTab().setText("下手").setTabListener(new TabListener() {

			@Override
			public void onTabSelected(Tab paramTab, FragmentTransaction paramFragmentTransaction) {
				init("0");
			}

			@Override
			public void onTabUnselected(Tab paramTab, FragmentTransaction paramFragmentTransaction) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTabReselected(Tab paramTab, FragmentTransaction paramFragmentTransaction) {
				// TODO Auto-generated method stub

			}

		});

		actionBar.addTab(tab);

		tab = actionBar.newTab().setText("上手").setTabListener(new TabListener() {

			@Override
			public void onTabSelected(Tab paramTab, FragmentTransaction paramFragmentTransaction) {
				init("1");
			}

			@Override
			public void onTabUnselected(Tab paramTab, FragmentTransaction paramFragmentTransaction) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTabReselected(Tab paramTab, FragmentTransaction paramFragmentTransaction) {
				// TODO Auto-generated method stub

			}

		});

		actionBar.addTab(tab);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	private void init(final String delflg) {
		swipeDismissListView = (SwipeDismissListView) findViewById(R.id.swipeDismissListView);

		final DBUtil db = new DBUtil(getBaseContext());
		List<String> dataList = db.findWords("", delflg);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, dataList);

		Tab tab = getActionBar().getSelectedTab();
		if ("1".equals(delflg)) {
			tab.setText("上手  (" + dataList.size() + ")");
		} else {
			tab.setText("下手  (" + dataList.size() + ")");
		}

		swipeDismissListView.setAdapter(adapter);

		swipeDismissListView.setOnDismissCallback(new OnDismissCallback() {

			@Override
			public void onDismiss(int dismissPosition) {
				db.updateStatus(adapter.getItem(dismissPosition).split("\\.")[0]);
				adapter.remove(adapter.getItem(dismissPosition));
				Tab tab = getActionBar().getSelectedTab();
				if ("1".equals(delflg)) {
					tab.setText("上手  (" + adapter.getCount() + ")");
				} else {
					tab.setText("下手  (" + adapter.getCount() + ")");
				}
			}
		});

		swipeDismissListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				DBUtil db = new DBUtil(RemWordsActivity.this);
				String wordId = adapter.getItem(position).split("\\.")[0];
				Intent intent = new Intent(RemWordsActivity.this, ShowContentActivity.class);

				WordListBean bean = db.query(wordId, "").get(0);

				intent.putExtra("wordInfo", new String[] { bean.getSpell(), bean.getWord(), bean.getMeaning() });
				startActivity(intent);
			}
		});

	}
}