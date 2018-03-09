package br.com.gda.sql;

import java.sql.SQLException;

public interface SqlStmt {
	public void generateStmt() throws SQLException;		
	
	
	public boolean checkStmtGeneration();	
	
	
	public void executeStmt() throws SQLException;
}