package com.homeProject.action;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Dao.ArticleCommentANDContentDao.Impl.ArticleCommentANDContentDaoImpl;
import com.Dao.ArticleCommentANDContentDao.Vo.ArticleCommentANDContentBean;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ArticleCommentANDContentAction extends ActionSupport {

	private List<ArticleCommentANDContentBean> articleList;
	private List<File> image = new ArrayList<File>();
	public List<File> getImage() {
		return image;
	}

	public void setImage(List<File> image) {
		this.image = image;
	}

	public List<ArticleCommentANDContentBean> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleCommentANDContentBean> articleList) {
		this.articleList = articleList;
	}

	public String findArticle() throws SQLException, ClassNotFoundException {

		ArticleCommentANDContentDaoImpl addArticle = new ArticleCommentANDContentDaoImpl();

		articleList = addArticle.findArticleCommentANDContent();
		return SUCCESS;
	}
}
