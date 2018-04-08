package br.com.gda.sql;

import java.sql.SQLException;
import java.util.List;

public interface SqlStmtExec<T> {
	public void executeStmt() throws SQLException;	
	
	public List<T> getResultset();
}
