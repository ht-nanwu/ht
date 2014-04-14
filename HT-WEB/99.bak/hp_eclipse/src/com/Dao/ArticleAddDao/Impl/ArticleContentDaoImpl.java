package com.Dao.ArticleAddDao.Impl;

import java.sql.SQLException;
import java.util.List;

import com.Dao.ArticleAddDao.ArticleContentDao;
import com.Dao.ArticleAddDao.Vo.ArticleAddBean;
import com.StaticParameters.StaticParameters;
import com.homeProject.common.Common;

public class ArticleContentDaoImpl implements ArticleContentDao,
		StaticParameters {

	public boolean createArticle(ArticleAddBean articleAdd,List<String[]> imagePath) throws SQLException, ClassNotFoundException {

		Common common = new Common();
		String[] inputValue = new String[6];
		inputValue[0] = articleAdd.getArticle_user();
		inputValue[1] = articleAdd.getArticle_title();
		inputValue[2] = articleAdd.getArticle_note();
		inputValue[3] = articleAdd.getArticle_content();
		inputValue[4] = articleAdd.getArticle_big_category();
		inputValue[5] = articleAdd.getArticle_small_category();
		
		common.excuteMySql(INSERTARTICLE, 1, null,inputValue,null);		
		common.excuteMySql(INSERTPATH, 2, null,null,imagePath);
		return true;
	}
}
