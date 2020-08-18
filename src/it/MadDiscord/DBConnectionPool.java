package it.MadDiscord;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DBConnectionPool  {

	private static List<Connection> freeDbConnections;

	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver not found:"+ e.getMessage());
		} 
	}
	
	private static synchronized Connection createDBConnection() throws SQLException {
		Connection newConnection = null;
		String ip = "localhost";
		String port = "3306";
		String db = "jdbc:sqlserver://data-a.database.windows.net:1433;database=DatabaseBadDiscord;user=dbroot@data-a;password=adminadmin1+;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		String username = "root";
		String password = "AntonioR99";

		newConnection = DriverManager.getConnection("jdbc:mysql://"+ ip+":"+ port+"/"+db, username, password);

		newConnection.setAutoCommit(false);
		return newConnection;
	}


	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();		
		}

		return connection;
	}

	public static synchronized void releaseConnection(Connection connection) {
		if(connection != null) freeDbConnections.add(connection);
	}
}
