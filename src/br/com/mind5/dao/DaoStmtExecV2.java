package br.com.mind5.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.info.InfoRecord;

public interface DaoStmtExecV2<T extends InfoRecord> {
	public void executeStmt() throws SQLException;	
	
	public List<T> getResultset();
	
	public void close();
}
