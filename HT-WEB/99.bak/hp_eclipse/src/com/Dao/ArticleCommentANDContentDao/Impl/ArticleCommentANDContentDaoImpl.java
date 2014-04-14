package com.Dao.ArticleCommentANDContentDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.Dao.ArticleCommentANDContentDao.ArticleCommentsANDContentDao;
import com.Dao.ArticleCommentANDContentDao.Vo.ArticleCommentANDContentBean;
import com.StaticParameters.StaticParameters;
import com.homeProject.common.Common;
import com.homeProject.common.DataBaseBean;

public class ArticleCommentANDContentDaoImpl implements ArticleCommentsANDContentDao,StaticParameters {

	public List<ArticleCommentANDContentBean> findArticleCommentANDContent() throws SQLException, ClassNotFoundException {
		
		Common common = new Common();
		DataBaseBean selectbean = new DataBaseBean();
		selectbean = (DataBaseBean)common.excuteMySql(SELECTARTICLEALL,0,null,null,null);
		List<ArticleCommentANDContentBean> resultSelectAll = new ArrayList<ArticleCommentANDContentBean>();
		ResultSet selectAll = selectbean.getResultselect();
		
		ArticleCommentANDContentBean resultSelectAllBean = null;
		SimpleDateFormat dateYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat dateMonthDay = new SimpleDateFormat("MM-dd");
		try {
			while(selectAll.next()){
				resultSelectAllBean = new ArticleCommentANDContentBean();
				resultSelectAllBean.setArticle_id(selectAll.getInt(1));
				resultSelectAllBean.setArticle_title(selectAll.getString(2));
				resultSelectAllBean.setArticle_note(selectAll.getString(3));
				resultSelectAllBean.setArticle_content(selectAll.getString(4));
				resultSelectAllBean.setArticle_big_category(selectAll.getString(5));
				resultSelectAllBean.setArticle_small_category(selectAll.getString(6));
				resultSelectAllBean.setArticle_user(selectAll.getString(7));
				resultSelectAllBean.setUpdatetime_year(dateYear.format(selectAll.getDate(8)));
				resultSelectAllBean.setUpdatetime_month_day(dateMonthDay.format(selectAll.getDate(8)));
				resultSelectAllBean.setUpdatetimeForTitle(selectAll.getDate(8));
				resultSelectAll.add(resultSelectAllBean);
			}
			common.closeMySql(selectbean.getResultselect(), selectbean.getConn(), selectbean.getPstmt());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("。。。。查询文章出错。。。。");
		}
		
		if(resultSelectAll != null){
			return resultSelectAll;
		}
		else {
			System.out.println("。。。。查询结果为空。。。。");
			return null;
		}
	}
	
}
