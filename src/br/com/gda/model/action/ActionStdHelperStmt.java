package br.com.gda.model.action;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.dao.DaoStmtExec;

public final class ActionStdHelperStmt<T> extends ActionStdTemplate<T> {
	private DaoStmtExec<T> stmtExec;
	
	
	public ActionStdHelperStmt(DaoStmtExec<T> sqlStmtExecutor) {
		super();
		checkArgument(sqlStmtExecutor);		
		stmtExec = sqlStmtExecutor;
	}
	
	
	
	private void checkArgument(DaoStmtExec<T> sqlStmtExecutor) {
		if (sqlStmtExecutor == null)
			throw new NullPointerException("sqlStmtExecutor" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override protected List<T> tryToExecuteActionHook() throws SQLException {
		stmtExec.executeStmt();
		return stmtExec.getResultset();
	} 
}
