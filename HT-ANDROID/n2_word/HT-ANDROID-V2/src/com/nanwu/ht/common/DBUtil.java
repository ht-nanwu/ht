package com.nanwu.ht.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nanwu.ht.bean.WordListBean;

public class DBUtil {
	private static final String DB_NAME = "n2_word.db";
	private static final String TBL_NAME = "n2_word";
	private static final String TARGET_TABLE = "/data/data/com.nanwu.ht/databases/n2_word.db";
	private SQLiteDatabase db;
	private Context c;

	public DBUtil(Context c) {
		this.c = c;
	}

	private void open() {
		try {
			if (!(new File(TARGET_TABLE).exists())) {
				AssetManager am = c.getAssets();
				InputStream is = am.open(DB_NAME);
				new File("/data/data/com.nanwu.ht/databases/").mkdirs();
				FileOutputStream fos = new FileOutputStream(TARGET_TABLE);
				byte[] buffer = new byte[1024];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}
				fos.close();
				is.close();
			}
			this.db = SQLiteDatabase.openOrCreateDatabase(TARGET_TABLE, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> findWords(String id, String delFlg) {
		List<WordListBean> list = this.query(id, delFlg);
		List<String> returnList = new ArrayList<String>();
		String temStr = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getWord().isEmpty()) {
				temStr = list.get(i).getId() + "." + list.get(i).getSpell();
			} else {
				temStr = list.get(i).getId() + "." + list.get(i).getWord();
			}

			returnList.add(temStr);
		}
		return returnList;
	}

	public List<WordListBean> query(String id, String delFlg) {
		open();
		Cursor cursor;
		if (id.isEmpty() && !delFlg.isEmpty()) {
			cursor = db.query(TBL_NAME, null, "del=?", new String[] { delFlg }, null, null, "RANDOM()");
		} else if (!id.isEmpty() && delFlg.isEmpty()) {
			cursor = db.query(TBL_NAME, null, "id=?", new String[] { id }, null, null, null);
		} else if(!id.isEmpty() && !delFlg.isEmpty()){
			cursor = db.query(TBL_NAME, null, "id=? AND del=?", new String[] { id, delFlg }, null, null, "RANDOM()");
		}else{
			cursor = db.query(TBL_NAME, null, null, null, null, null, "RANDOM()");
		}

		WordListBean point;
		List<WordListBean> wordList = new ArrayList<WordListBean>();
		while (cursor.moveToNext()) {
			point = new WordListBean();
			point.setId(cursor.getString(cursor.getColumnIndex("id")));
			point.setWord(cursor.getString(cursor.getColumnIndex("word")));
			point.setSpell(cursor.getString(cursor.getColumnIndex("spell")));
			point.setMeaning(cursor.getString(cursor.getColumnIndex("meaning")));
			wordList.add(point);
		}
		close();
		return wordList;
	}

	public void updateStatus(String id) {
		open();
		String delFlg = null;
		Cursor cursor = db.query(TBL_NAME, null, "id=?", new String[] { id }, null, null, null);
		while (cursor.moveToNext()) {
			delFlg = cursor.getString(cursor.getColumnIndex("del"));
		}
		ContentValues values = new ContentValues();

		if ("0".equals(delFlg)) {
			delFlg = "1";
		} else {
			delFlg = "0";
		}
		values.put("del", delFlg);
		db.update(TBL_NAME, values, "id=?", new String[] { id });
		close();
	}

	public void close() {
		if (db != null)
			db.close();
	}
}