package br.com.gda.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import br.com.gda.servlet.ServletContainerGDA;

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
		ds = ServletContainerGDA.datasource.get("jdbc/gdaDB");
	}
}
