import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.airticleInfo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import common.DButil;

public class test {
	public String doTest() {
		DButil a = new DButil();
		// TODO Auto-generated method stub
		a.select(airticleInfo.class, null);
		return "success";
	}

}
