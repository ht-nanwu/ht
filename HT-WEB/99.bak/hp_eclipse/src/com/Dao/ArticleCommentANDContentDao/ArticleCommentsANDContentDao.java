package com.Dao.ArticleCommentANDContentDao;

import java.sql.SQLException;
import java.util.List;
import com.Dao.ArticleCommentANDContentDao.Vo.ArticleCommentANDContentBean;

public interface ArticleCommentsANDContentDao {
	
	/**
	 * 根据文章id取得文章内容
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * 
	 */
	 List<ArticleCommentANDContentBean> findArticleCommentANDContent() throws SQLException, ClassNotFoundException;	
	 
}
