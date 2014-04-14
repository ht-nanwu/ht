package com.nanwu.ht;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
       
        actionBar.setDisplayShowTitleEnabled(true);
        
        Tab tab = actionBar.newTab()
        		.setText("上手")
        		.setTabListener(new CustomTabListener<WordsRemedFragment>(this, "上手", WordsRemedFragment.class));
        
        actionBar.addTab(tab);
        
        tab = actionBar.newTab()
        		.setText("下手")
        		.setTabListener(new CustomTabListener<WordsToRemFragment>(this, "下手", WordsToRemFragment.class));

        
        actionBar.addTab(tab);            
        
        
    }
}