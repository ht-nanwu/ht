package com.homeProject.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.StaticParameters.StaticParameters;
import com.homeProject.common.Common;
import com.homeProject.common.DataBaseBean;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ShowImageAction extends ActionSupport implements StaticParameters {

	private int imagepath;
	
	private String id;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getImagepath() {
		return imagepath;
	}

	public void setImagepath(int imagepath) {
		this.imagepath = imagepath;
	}

	public String getImage() {

		HttpServletResponse response = null;
		ServletOutputStream out = null;
		InputStream in = null;
		byte[] bytes = null;
		Object[] inputValueArray = new Object[2];
		inputValueArray[0] = id;
		inputValueArray[1] = imagepath;
		try {
			response = ServletActionContext.getResponse();
			// 二进制输出流
			response.setContentType("multipart/form-data");
			// 得到输出流
			out = response.getOutputStream();
			// 得到Blob类实例，使用.getBinaryStream()得到输入流。
			// 这里的image就是blob类
			Common common = new Common();
			DataBaseBean selectbean = new DataBaseBean();
			selectbean = (DataBaseBean)common.excuteMySql(SELECTPATH, 4,null,inputValueArray, null);
			ResultSet selectAll = selectbean.getResultselect();
			while(selectAll.next()){
				in = new FileInputStream(new File(selectbean.getResultselect().getString(1)));
			}
			// 从输入流读取数据到输出流
			bytes = new byte[(int) in.available()];
			in.read(bytes);
			out.write(bytes);
			// while (-1 != in.read(bytes)) {s
			// out.write(bytes);
			// }
			// 强制刷新输出流
			out.flush();
			common.closeMySql(selectbean.getResultselect(), selectbean.getConn(), selectbean.getPstmt());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			bytes = null;
		}
		return null;

	}
}
