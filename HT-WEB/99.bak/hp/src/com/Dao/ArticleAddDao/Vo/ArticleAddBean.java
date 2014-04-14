package com.Dao.ArticleAddDao.Vo;

import java.util.Date;

public class ArticleAddBean {
	
	private String article_title;
	private String article_note;
	private String article_big_category;
	private String article_small_category;
	private String article_content;
	private String article_user;
	private String article_exist;
	private Date updatetime;
	
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String articleTitle) {
		article_title = articleTitle;
	}
	public String getArticle_note() {
		return article_note;
	}
	public void setArticle_note(String articleNote) {
		article_note = articleNote;
	}
	public String getArticle_big_category() {
		return article_big_category;
	}
	public void setArticle_big_category(String articleBigCategory) {
		article_big_category = articleBigCategory;
	}
	public String getArticle_small_category() {
		return article_small_category;
	}
	public void setArticle_small_category(String articleSmallCategory) {
		article_small_category = articleSmallCategory;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String articleContent) {
		article_content = articleContent;
	}
	public String getArticle_user() {
		return article_user;
	}
	public void setArticle_user(String articleUser) {
		article_user = articleUser;
	}
	public String getArticle_exist() {
		return article_exist;
	}
	public void setArticle_exist(String articleExist) {
		article_exist = articleExist;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	
}
