import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConverMysqlToSqlit {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		List<String> delList = getDelList();

		Connection connection = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		List<Object[]> rsList = null;
		try {
			String databaseName = "ht";
			String host = "localhost";
			String port = "3306";
			String username = "root";
			String password = "318821wan";
			String driverName = "com.mysql.jdbc.Driver";
			String dbUrl = "jdbc:mysql://";
			String serverName = host + ":" + port + "/";
			String connName = dbUrl + serverName + databaseName;

			Class.forName(driverName);
			connection = DriverManager.getConnection(connName, username, password);
			for (String id : delList) {
				ptmt = connection.prepareStatement("update n2_word set del='1' where id=?");
				ptmt.setString(1, id);
				ptmt.execute();
				System.out.println(id);
			}
			ptmt = connection.prepareStatement("update n2_word set meaning=REPLACE(meaning,'\\'','') WHERE meaning like '%\\'%'");
			ptmt.execute();
			rs = ptmt.executeQuery("select * from n2_word");
			rsList = new ArrayList<Object[]>();
			while (rs.next()) {
				rsList.add(new Object[] { rs.getString("id"), rs.getString("spell"), rs.getString("word"), rs.getString("meaning"),
				        rs.getString("del"), rs.getTimestamp("updateTime") });
			}
			updateN2Sqlit(rsList);
		} catch (Exception e) {
			rs.close();
			ptmt.close();
			connection.close();
			e.printStackTrace();
		}
	}

	private static void updateN2Sqlit(List<Object[]> list) throws SQLException {
		Connection conn = null;
		PreparedStatement ptmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:n2_word.db", null, null);
			ptmt = conn.prepareStatement("INSERT INTO `n2_word` (`id`, `spell`, `word`, `meaning`, `del`, `updateTime`) VALUES (?, ?, ?, ?, ?, ?)");
			for (int i = 0; i < list.size(); i++) {
				ptmt.setObject(1, list.get(i)[0]);
				ptmt.setObject(2, list.get(i)[1]);
				ptmt.setObject(3, list.get(i)[2]);
				ptmt.setObject(4, list.get(i)[3]);
				ptmt.setObject(5, list.get(i)[4]);
				ptmt.setObject(6, list.get(i)[5]);
				ptmt.execute();
				System.out.println(list.get(i)[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ptmt.close();
			conn.close();
		}
	}

	private static List<String> getDelList() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> delWordsIdList = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:n2_word.db", null, null);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id from n2_word where del='1'");
			delWordsIdList = new ArrayList<String>();
			while (rs.next()) {
				delWordsIdList.add(rs.getString(1));
			}
			stmt.execute("DELETE FROM n2_word");
			return delWordsIdList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}

		return delWordsIdList;
	}
}
