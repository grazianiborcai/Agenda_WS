package br.com.gda.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoStmt<T> {
	public void generateStmt() throws SQLException;		
	
	
	public boolean checkStmtGeneration();	
	
	
	public void executeStmt() throws SQLException;
	
	
	public List<T> getResultset();	
	
	
	public DaoStmt<T> getNewInstance();
}