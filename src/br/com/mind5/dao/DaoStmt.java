package br.com.mind5.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoStmt<T> {
	public void close();
	
	public boolean checkStmtGeneration();		
	
	public void executeStmt() throws SQLException;	
	
	public List<T> getResultset();
}