package br.com.gda.sql;

import java.sql.SQLException;
import java.util.List;

public interface SqlStmt<T> {
	public void generateStmt() throws SQLException;		
	
	
	public boolean checkStmtGeneration();	
	
	
	public void executeStmt() throws SQLException;
	
	
	public List<T> getResultset();	
	
	
	public SqlStmt<T> getNewInstance();
}