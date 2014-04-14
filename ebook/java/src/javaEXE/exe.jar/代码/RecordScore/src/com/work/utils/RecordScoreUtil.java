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
 * @author 操作csv文件
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
	 * @param input
	 *            界面上输入信息
	 * @return csv文件成功状况
	 */
	public boolean writeToCsv(String[] input) {
		logger.info("csv file update begining...");
		FileOutputStream fos = null;
		Writer out = null;
		FileWriter write = null;
		try {
			if (new File(root + "\\data\\CsvCreater.csv").exists()) {
				write = new FileWriter(root + "\\data\\CsvCreater.csv", true);
				write.write(formatStr(input) + "\n");
			} else {
//				fos = new FileOutputStream(root + "\\data\\CsvCreater.csv");
//				out = new OutputStreamWriter(fos);
//				out.write("学号,姓名,学科,等级," + "\n");
//				out.write(formatStr(input) + "\n");
				write = new FileWriter(root + "\\data\\CsvCreater.csv", true);
				write.write("学号,姓名,学科,等级," + "\n");
				write.write(formatStr(input) + "\n");
				logger.info("csv file update ending...");
			}
		} catch (IOException e) {
			logger.info("csv file update has exceptions");
			logger.info(e.getMessage());
		} finally {
			try {
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
				logger.info("csv file update has exceptions");
				logger.info(e.getMessage());
			}

		}
		return false;
	}

	/**
	 * 
	 * @return 所有学生成绩
	 */
	public String[][] readFromCsv() {
		logger.info("csv file read begining...");
		List<String> list = new ArrayList<String>();
		String[][] returnArgs = null;
		BufferedReader bufferedreader = null;
		try {

			bufferedreader = new BufferedReader(new FileReader(root + "\\data\\CsvCreater.csv"));
			String stemp;
			while ((stemp = bufferedreader.readLine()) != null) {
				list.add(stemp);
			}
			list.remove(0);
			returnArgs = new String[list.size()][4];
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					returnArgs[i][0] = list.get(i).split(",")[0];
					returnArgs[i][1] = list.get(i).split(",")[1];
					returnArgs[i][2] = list.get(i).split(",")[2];
					returnArgs[i][3] = list.get(i).split(",")[3];
				}
			}
		} catch (Exception e) {
			logger.info("csv file reading has exceptions");
			logger.info(e.getMessage());
		} finally {
			if (bufferedreader != null) {
				try {
					bufferedreader.close();
				} catch (IOException e) {
					logger.info("csv file reading closed exceptions");
					logger.info(e.getMessage());
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
	 * 控件居中
	 * 
	 * @param component
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
