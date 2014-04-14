package com.Dao.ArticleAddDao;

import java.sql.SQLException;
import java.util.List;

import com.Dao.ArticleAddDao.Vo.ArticleAddBean;

public interface ArticleContentDao {
	
	/**
	 * 创建新的文章
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * 
	 */
	public boolean createArticle(ArticleAddBean articleAdd,List<String[]> imagePath) throws SQLException, ClassNotFoundException;
	
}
