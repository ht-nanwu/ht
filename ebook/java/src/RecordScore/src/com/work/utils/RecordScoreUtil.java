package com.work.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 学生成绩用共通函数
 * 
 * @version 1.0.0
 * 
 * @author 曹毅
 * 
 */
public class RecordScoreUtil {

	private String root;
	private Logger logger = Logger.getLogger(RecordScoreUtil.class);;

	/**
	 * @param root
	 *            根目录
	 */
	public RecordScoreUtil(String root) {
		this.root = root;
	}

	/**
	 * 把学生成绩情况写到csv文件
	 * 
	 * @param input
	 *            界面上输入信息
	 * @return csv文件成功状况
	 */
	public boolean writeToCsv(String[] input) {
		
		logger.info("开始写入文件");
		FileOutputStream fos = null;
		Writer out = null;
		FileWriter write = null;
		boolean successFlg = true;
		
		try {
			if (new File(root + "\\data\\CsvCreater.csv").exists()) {
				
				write = new FileWriter(root + "\\data\\CsvCreater.csv", true);
				write.write(formatStr(input) + "\n");
			
			} else {
				
				logger.info("csv文件不存在，创建csv文件，并且写入抬头和第一行数据。");
				
				write = new FileWriter(root + "\\data\\CsvCreater.csv", true);
				write.write("学号,姓名,学科,等级," + "\n");
				write.write(formatStr(input) + "\n");
				
				logger.info("csv文件写入成功。");
			}
		} catch (IOException e) {
			logger.error("文件写入失败");
			logger.error(e.getMessage());
			successFlg = false;
		} finally {
			try {
				logger.error("关闭文件流开始。");
				if (write != null) {
					write.close();
				}
				if (out != null) {
					out.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				logger.error("csv文件流关闭失败！！！");
				logger.error(e.getMessage());
				successFlg = false;
			}
		}
		return successFlg;
	}

	/**
	 * 
	 * 读取csv文件，获取学生成绩信息
	 * 
	 * @return 所有学生成绩
	 */
	public String[][] readFromCsv() {
		
		logger.info("读取学生成绩信息csv开始。");
		List<String> list = new ArrayList<String>();
		String[][] returnArgs = null;
		BufferedReader bufferedreader = null;
		try {
			
			// 读取全部信息
			bufferedreader = new BufferedReader(new FileReader(root + "\\data\\CsvCreater.csv"));
			String stemp;
			while ((stemp = bufferedreader.readLine()) != null) {
				list.add(stemp);
			}
			
			// 去除抬头信息
			list.remove(0);
			returnArgs = new String[list.size()][4];
			
			// 数据格式化
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					returnArgs[i][0] = list.get(i).split(",")[0];
					returnArgs[i][1] = list.get(i).split(",")[1];
					returnArgs[i][2] = list.get(i).split(",")[2];
					returnArgs[i][3] = list.get(i).split(",")[3];
				}
			}
		} catch (Exception e) {
			logger.error("读取学生成绩信息csv失败！！！");
			logger.error(e.getMessage());
		} finally {
			if (bufferedreader != null) {
				try {
					bufferedreader.close();
				} catch (IOException e) {
					logger.error("关闭流失败！！！");
					logger.error(e.getMessage());
				}
			}
		}
		return returnArgs;
	}

	/**
	 * 按条件查询
	 * 
	 * @param itemIndex
	 * @param itemValue
	 * @param isLike
	 * @return
	 */
	public List<String[]> readFromCsvBy(int itemIndex, String itemValue, boolean isLike) {
		List<String[]> returnList = new ArrayList<String[]>();
		String[][] args = this.readFromCsv();
		if (itemValue.isEmpty()) {
			for (int i = 0; args != null && i < args.length; i++) {
				returnList.add(args[i]);
			}
		} else {
			if (isLike) {
				for (int i = 0; args != null && i < args.length; i++) {
					if (args[i][itemIndex].contains(itemValue)) {
						returnList.add(args[i]);
					}
				}
			} else {
				for (int i = 0; args != null && i < args.length; i++) {
					if (args[i][itemIndex].equals(itemValue)) {
						returnList.add(args[i]);
					}
				}
			}
		}
		return returnList;
	}

	/**
	 * 设置控件在屏幕中间
	 * 
	 * @param 控件对象
	 */
	public static void setCenter(Component component) {
		Dimension dem = Toolkit.getDefaultToolkit().getScreenSize();
		int sHeight = dem.height;
		int sWidth = dem.width;
		int fHeight = component.getHeight();
		int fWidth = component.getWidth();
		component.setLocation((sWidth - fWidth) / 2, (sHeight - fHeight) / 2);
	}

	/**
	 * @param args
	 *            数据字符串
	 * @return 拼接后的字符串
	 */
	private String formatStr(String[] args) {
		StringBuffer outputStr = new StringBuffer();
		for (String str : args) {
			outputStr.append(str + ",");
		}
		return String.valueOf(outputStr).substring(0, String.valueOf(outputStr).lastIndexOf(","));
	}
}
