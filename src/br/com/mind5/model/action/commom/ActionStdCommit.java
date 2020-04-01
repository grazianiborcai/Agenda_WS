package br.com.mind5.model.action.commom;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.common.DeciResultError;

public final class ActionStdCommit<T> extends ActionStdTemplate<T> {	
	private Connection dbCon;
	private List<T> recordInfos;
	
	
	public ActionStdCommit(List<T> records, Connection conn) {
		super();
		checkArgument(records, conn);
		dbCon = conn;
		recordInfos = records;
	}
	
	
	
	@Override protected List<T> tryToExecuteActionReturnListHook() throws SQLException {
		commitWork();
		return recordInfos;
	}
	
	
	
	private void commitWork() throws SQLException {
		dbCon.commit();
		//TODO: incluir rollback em caso de falha ?
	}
	
	
	
	@Override protected DeciResult<T> buildResultFailedHook() {
		return new DeciResultError<T>();
	}
	
	
	
	private void checkArgument(List<T> records, Connection conn) {
		if (records == null) {
			logException(new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
			
			
		if (conn == null) {
			logException(new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
