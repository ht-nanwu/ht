import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
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
			stmt = connection.createStatement();
//			rs = stmt.executeQuery("select id,spell from n2_word where word='' and del='0'");
//			getUrl = new GetUrlContent();
//			while (rs.next()) {
//				ptmt = connection.prepareStatement("update n2_word set meaning=? where id=?");
//				ptmt.setString(1, getUrl.getUrlContent(rs.getString(2)));
//				ptmt.setString(2, rs.getString(1));
//				ptmt.execute();
//				System.out.println(rs.getString(1));
//			}
			rs = stmt.executeQuery("select id,meaning from n2_word_old where id in (select id from n2_word where meaning='')");
			while (rs.next()) {
				ptmt = connection.prepareStatement("update n2_word set meaning=? where id=?");
				ptmt.setString(1, rs.getString(2));
				ptmt.setString(2, rs.getString(1));
				ptmt.execute();
				System.out.println(rs.getString(1));
			}

		} catch (Exception e) {
			rs.close();
			ptmt.close();
			stmt.close();
			connection.close();
		}
	}

}
