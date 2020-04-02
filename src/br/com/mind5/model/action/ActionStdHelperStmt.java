package br.com.mind5.model.action;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.info.InfoRecord;

public final class ActionStdHelperStmt<T extends InfoRecord> extends ActionStdTemplate<T> {
	private DaoStmtExec_<T> stmtExec;
	
	
	public ActionStdHelperStmt(DaoStmtExec_<T> sqlStmtExecutor) {
		super();
		checkArgument(sqlStmtExecutor);		
		stmtExec = sqlStmtExecutor;
	}
	
	
	
	private void checkArgument(DaoStmtExec_<T> sqlStmtExecutor) {
		if (sqlStmtExecutor == null) {
			logException(new NullPointerException("sqlStmtExecutor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sqlStmtExecutor" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	@Override protected List<T> tryToExecuteActionReturnListHook() throws SQLException {
		stmtExec.executeStmt();
		return stmtExec.getResultset();
	} 
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
