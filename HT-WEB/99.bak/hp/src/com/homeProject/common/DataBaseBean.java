package com.homeProject.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseBean {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet resultselect;
	
	public ResultSet getResultselect() {
		return resultselect;
	}

	public void setResultselect(ResultSet resultselect) {
		this.resultselect = resultselect;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
}
