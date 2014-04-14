package com.Dao.ArticleCommentANDContentDao.Vo;

import java.util.Date;

public class ArticleCommentANDContentBean {
	
	private int article_id;
	private String article_title;
	private String article_note;
	private String article_big_category;
	private String article_small_category;
	private String article_content;
	private String article_user;
	private String article_exist;
	private String updatetime_year;
	private String updatetime_month_day;
	private Date updatetimeForTitle;
	
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int articleId) {
		article_id = articleId;
	}
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
	
	public String getUpdatetime_year() {
		return updatetime_year;
	}
	public void setUpdatetime_year(String updatetimeYear) {
		updatetime_year = updatetimeYear;
	}
	
	public String getUpdatetime_month_day() {
		return updatetime_month_day;
	}
	public void setUpdatetime_month_day(String updatetimeMonthDay) {
		updatetime_month_day = updatetimeMonthDay;
	}
	public Date getUpdatetimeForTitle() {
		return updatetimeForTitle;
	}
	public void setUpdatetimeForTitle(Date updatetimeForTitle) {
		this.updatetimeForTitle = updatetimeForTitle;
	}
	
}
