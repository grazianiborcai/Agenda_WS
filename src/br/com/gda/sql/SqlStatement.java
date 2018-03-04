package br.com.gda.sql;

import java.sql.SQLException;

public interface SqlStatement {
	public void generateStmt() throws SQLException;
	
	
	
	public boolean checkStatementGeneration();
}
