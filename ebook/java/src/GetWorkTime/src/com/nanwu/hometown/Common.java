package com.nanwu.hometown;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Common {

	private Connection conn;

	private PreparedStatement pstm;

	private PreparedStatement getConn(String sqlStr) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://10.6.1.129:3306/knockoff";
			conn = DriverManager.getConnection(url, "root", "318821wan");
			pstm = conn.prepareStatement(sqlStr);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return pstm;
	}

	private void colse() {
		try {
			conn.close();
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update() throws ParseException {
		try {
			Date now = Calendar.getInstance().getTime();
			String sysStartTime = select().get(0).get("knock_on_time");

			pstm = getConn("UPDATE `time_confirm` SET `knock_off_time`=?,`lasts`=? WHERE `show_day`=?");
			pstm.setString(1, strToDate(Calendar.getInstance().getTime(), "yyyy-MM-dd HH:mm:ss"));

			int lastsSeconds = getLastsSecond(sysStartTime, strToDate(Calendar.getInstance().getTime(), "yyyy-MM-dd HH:mm:ss"));
			int lastsHours = lastsSeconds / 3600;
			int lastsMin = (lastsSeconds - lastsHours * 3600) / 60;
			int second = lastsSeconds - lastsHours * 3600 - lastsMin * 60;

			pstm.setString(2, lastsHours + "小时," + lastsMin + "分钟," + second + "秒。");

			pstm.setString(3, strToDate(now, "yyyy-MM-dd"));

			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colse();
		}
	}

	public String[] insert() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String beginTimeStr = getStartTime();
			Date beginTime = sdf.parse(getStartTime());
			pstm = getConn("INSERT INTO time_confirm (`show_day`, `knock_on_time`, `knock_off_time`, `lasts`) VALUES(?,?,?,null)");
			pstm.setString(1, strToDate(Calendar.getInstance().getTime(), "yyyy-MM-dd"));
			pstm.setString(2, beginTimeStr);

			Calendar knockoff = Calendar.getInstance();
			knockoff.setTime(beginTime);
			knockoff.add(Calendar.HOUR, 9);
			pstm.setString(3, strToDate(knockoff.getTime(), "yyyy-MM-dd HH:mm:ss"));

			if (pstm.execute()) {
				return new String[] { String.valueOf(knockoff.getTime()) };
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} finally {
			colse();
		}
		return null;
	}

	public List<Map<String, String>> select() {
		List<Map<String, String>> returnValues = new ArrayList<Map<String, String>>();
		Map<String, String> eachMap = null;
		try {
			pstm = getConn("SELECT * FROM time_confirm WHERE show_day=?");
			pstm.setString(1, strToDate(Calendar.getInstance().getTime(), "yyyy-MM-dd"));

			ResultSet rst = pstm.executeQuery();
			while (rst.next()) {
				eachMap = new HashMap<String, String>();
				eachMap.put("show_day", rst.getString("show_day"));
				eachMap.put("knock_on_time", rst.getString("knock_on_time"));
				eachMap.put("knock_off_time", rst.getString("knock_off_time"));
				eachMap.put("lasts", rst.getString("lasts"));
				returnValues.add(eachMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			colse();
		}
		return returnValues;
	}

	public static String strToDate(Date orgnTime, String format) {
		SimpleDateFormat sdf;
		String returnDate = null;
		if (format.isEmpty()) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else {
			sdf = new SimpleDateFormat(format);
		}

		returnDate = sdf.format(orgnTime);
		return returnDate;
	}

	public int getLastsSecond(String beginTime, String EndTime) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar begin = Calendar.getInstance();
		begin.setTime(sdf.parse(beginTime));
		int beginHour = begin.get(Calendar.HOUR_OF_DAY);
		int beginMin = begin.get(Calendar.MINUTE);
		int beginSecond = begin.get(Calendar.SECOND);

		Calendar end = Calendar.getInstance();
		end.setTime(sdf.parse(EndTime));
		int endHour = end.get(Calendar.HOUR_OF_DAY);
		int endMin = end.get(Calendar.MINUTE);
		int endSecond = end.get(Calendar.SECOND);

		return endHour * 3600 + endMin * 60 + endSecond - beginHour * 3600 - beginSecond - beginMin * 60;
	}

	private String getStartTime() {
		try {
			Process pro = Runtime.getRuntime().exec("systeminfo");
			InputStreamReader isr = new InputStreamReader(pro.getInputStream(), "shift_jis");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("システム起動時間:")) {
					return line.split("システム起動時間:")[1].trim().replace(",", "").replace("/", "-");
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void backupMysql(){
		try {
			Process pro = Runtime.getRuntime().exec("cmd /c \"C://Program Files (x86)//MySQL//MySQL Server 5.1//bin//mysqldump\" -uroot -p318821wan -B HT>backup.sql");
			pro.waitFor();
			zipFile("backup.sql","backup.zip");
			(new File("backup.sql")).delete();
		} catch (Exception e) {
	        e.printStackTrace();
        }
	}
	private void zipFile(String fileName, String zipName) {
		byte[] buffer = new byte[1024];

		try {
			FileOutputStream fos = new FileOutputStream(zipName);
			ZipOutputStream zos = new ZipOutputStream(fos);
			ZipEntry ze = new ZipEntry(fileName);
			zos.putNextEntry(ze);
			FileInputStream in = new FileInputStream(fileName);

			int len;
			while ((len = in.read(buffer)) > 0) {
				zos.write(buffer, 0, len);
			}

			in.close();
			zos.closeEntry();
			zos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			
		}
	}
}
