package br.com.mind5.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoStmtExec<T> {
	public void executeStmt() throws SQLException;	
	
	public List<T> getResultset();
}
