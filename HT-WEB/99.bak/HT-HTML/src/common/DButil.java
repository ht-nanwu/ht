package common;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DButil {
	private Connection conn = null;
	private ResultSet rs = null;
	private java.sql.PreparedStatement stmt = null;

	/**
	 * 数据库连接
	 * 
	 */
	private Connection getConnect() {
		try {

			// 加载驱动程序
			Class.forName(this.getProperties("driver"));
			// 连续数据库
			String url = this.getProperties("url");
			String user = this.getProperties("user");
			String password = this.getProperties("password");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 数据库关闭
	 * 
	 */
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public <T> List<Object> select(Class<T> className,
			Map<String, String> condition) {

		List<Object> returnValue = new ArrayList<Object>();
		try {
			this.conn = getConnect();
			this.stmt = this.conn
					.prepareStatement("select title,topic from articleInfo");
			this.rs = this.stmt.executeQuery();
			String[] inputValue = new String[className.getDeclaredFields().length];

			while (this.rs.next()) {
				for (int i = 0; i < inputValue.length; i++) {
					inputValue[i] = String.valueOf(this.rs.getObject(i + 1));
				}
				returnValue.add(setFiled(className, inputValue));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	private <T> Object setFiled(Class<T> className, String... inputValue) {

		Object classInstance = null;
		// 获取bean里面的所有变量名
		Field[] fields = className.getDeclaredFields();
		// bean里的set方法名
		String filedToMethod;
		try {
			// 新对象
			classInstance = className.newInstance();
			for (int i = 0; i < fields.length; i++) {
				filedToMethod = fields[i].getName();
				filedToMethod = filedToMethod.replaceFirst("[a-z]{1}",
						(char) (filedToMethod.charAt(0) - 32) + "");
				filedToMethod = "set" + filedToMethod;

				className.getMethod(filedToMethod, String.class).invoke(
						classInstance, inputValue[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classInstance;
	}

	/**
	 * 配置文件属性读取
	 * 
	 * @param key
	 *            属性标识符
	 * @return 属性值
	 */
	public String getProperties(String key) {
		Properties prop = new Properties();
		InputStream in = Object.class
				.getResourceAsStream("../../DBConfig.properties");

		String returnValue = null;
		try {
			prop.load(in);
			returnValue = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}