package br.com.gda.model.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		if (sqlStmtExecutor == null) {
			logException(new NullPointerException("sqlStmtExecutor" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sqlStmtExecutor" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	@Override protected List<T> tryToExecuteActionListHook() throws SQLException {
		stmtExec.executeStmt();
		return stmtExec.getResultset();
	} 
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
