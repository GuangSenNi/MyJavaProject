package per.ngs.gecco.daomain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoSupport {
	Connection connection =null;
	Statement statement =null;
	ResultSet resultSet =null;
	String url = "jdbc:mysql://localhost:3306/incsu";

	public DaoSupport()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(url,"root","19961028");
			statement=connection.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void close() {
		try {
			if (connection!=null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
