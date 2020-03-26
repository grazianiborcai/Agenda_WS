package br.com.mind5.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public final class DbConnection {
	private static DataSource ds;
	
	
	public static void initialize(DataSource dataSource) {
		ds = dataSource;
	}
	
	
	
	public static synchronized Connection getConnection() {
		try {
			Connection newConn = ds.getConnection();
			newConn.setAutoCommit(false);
			return newConn;
			
		} catch (SQLException e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR); 
		}
	}
	
	
	
	public static synchronized void closeConnection(Connection conn) {
		rollback(conn);
		close(conn);
	}
	
	
	
	private static void rollback(Connection conn) {
		try {
			if (conn != null)
				conn.rollback();
			
		} catch (SQLException e) {
		}
	}
	
	
	
	private static void close(Connection conn) {
		try {
			if (conn != null) 
				conn.close();
			
		} catch (SQLException e) {
		}
		
		conn = null;
	}
}
