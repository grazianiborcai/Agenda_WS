package br.com.gda.model.decisionTree;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlStmtExec;

public final class DeciActionHelperStmt<T> extends DeciActionHelperTemplate<T> {
	private SqlStmtExec<T> stmtExec;
	
	
	public DeciActionHelperStmt(SqlStmtExec<T> sqlStmtExecutor) {
		super();
		checkArgument(sqlStmtExecutor);		
		stmtExec = sqlStmtExecutor;
	}
	
	
	
	private void checkArgument(SqlStmtExec<T> sqlStmtExecutor) {
		if (sqlStmtExecutor == null)
			throw new NullPointerException("sqlStmtExecutor" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override protected List<T> tryToExecuteActionHook() throws SQLException {
		stmtExec.executeStmt();
		return stmtExec.getResultset();
	} 
}
