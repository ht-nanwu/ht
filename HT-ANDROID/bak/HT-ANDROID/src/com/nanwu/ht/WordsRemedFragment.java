package com.nanwu.ht;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class WordsRemedFragment extends ListFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		DBUtil db= new DBUtil(getActivity().getBaseContext());
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, db.findWords());
		setListAdapter(adapter);
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		DBUtil db = new DBUtil(getActivity().getBaseContext());
		String wordId = String.valueOf(((TextView) v).getText()).split("\\.")[0];
		Intent intent = new Intent(getActivity().getBaseContext(), ShowContentActivity.class);
		
		WordListBean bean = db.query(wordId).get(0);
				
		intent.putExtra("wordInfo", new String[]{bean.getSpell(),bean.getWord(),bean.getMeaning()});
		startActivity(intent);
	}



	@Override
	public void onStart() {
		super.onStart();
		
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);		
	}
	
	
	
}
