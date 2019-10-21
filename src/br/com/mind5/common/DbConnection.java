package br.com.mind5.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import br.com.mind5.servlet.ServletMind5;

public final class DbConnection {
	private static DataSource ds;
	
	public static Connection getConnection() {
		try {
			if (ds == null)
				initialize();
			
			Connection newConn = ds.getConnection();
			newConn.setAutoCommit(false);
			return newConn;
			
		} catch (SQLException e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR); 
		}
	}
	
	
	
	private static void initialize() {
		ds = ServletMind5.datasource.get("jdbc/gdaDB");
	}
	
	
	
	public static void closeConnection(Connection conn) {
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
