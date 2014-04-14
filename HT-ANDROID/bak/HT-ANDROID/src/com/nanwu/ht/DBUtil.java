package com.nanwu.ht;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBUtil extends SQLiteOpenHelper {
    private static final String DB_NAME = "n2_word.db";
    private static final String TBL_NAME = "n2_word";
    private static final String CREATE_TBL = " create table "
            + " n2_word(_id integer primary key autoincrement,spell text,word text,meaning text) ";

    private SQLiteDatabase db;

    DBUtil(Context c) {
        super(c, DB_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(CREATE_TBL);
    }
    public String[] findWords(){
        List<WordListBean> list = this.query("");
        String[] returnArr = new String[list.size()];
        String temStr = "";
        for(int i=0;i<list.size();i++)
        {	
        	if(list.get(i).getWord().isEmpty()){
        		temStr = list.get(i).getId()+"."+list.get(i).getSpell();
        	}else{
        		temStr = list.get(i).getId()+"."+list.get(i).getWord();
        	}
            
            returnArr[i] = temStr;
        }
        return returnArr;
    }
    public List<WordListBean> query(String id) {
         db = getWritableDatabase();
         Cursor cursor;
         if(id.isEmpty()){
        	 cursor = db.query(TBL_NAME, null, null, null, null, null, null);
         }else{
        	 cursor = db.query(TBL_NAME, null, "id=?", new String[]{id}, null, null, null);
         }
         
        WordListBean point;
        List<WordListBean> wordList = new ArrayList<WordListBean>();
        while (cursor.moveToNext()) {  
            point = new WordListBean();  
            point.setId(cursor.getString(cursor  
                    .getColumnIndex("id")));  
            point.setWord(cursor.getString(cursor  
                    .getColumnIndex("word")));  
            point.setSpell(cursor.getString(cursor  
                    .getColumnIndex("spell"))); 
            point.setMeaning(cursor.getString(cursor  
                    .getColumnIndex("meaning"))); 
            wordList.add(point);  
        }  
        close();
        return wordList;
    }

    public void del(int id) {
        db = getWritableDatabase();
        db.delete(TBL_NAME, "_id=?", new String[] { String.valueOf(id) });
        close();
    }
    public void insert() {
        db = getWritableDatabase();
        db.execSQL("insert into n2_word(spell,word,meaning) values ('bb','bb','bb')");
        close();
    }

    public void close() {
        if (db != null)
            db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}