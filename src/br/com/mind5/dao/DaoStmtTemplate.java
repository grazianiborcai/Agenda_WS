package br.com.mind5.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.info.InfoRecord;


public abstract class DaoStmtTemplate<T extends InfoRecord> implements DaoStmt<T> {
	private DaoStmt<T> helper;
	
	
	protected DaoStmtTemplate(Connection conn, T recordInfo, String schemaName) {
		checkArgument(conn, recordInfo, schemaName);
			
		DaoStmtOption<T> stmtOption = buildStmtOption(conn, recordInfo, schemaName);
		helper = buildHelper(stmtOption);
	}
	
	
	
	private DaoStmtOption<T> buildStmtOption(Connection conn, T recordInfo, String schemaName) {
		DaoStmtOption<T> option = new DaoStmtOption<>();

		option.conn = conn;
		option.recordInfo = recordInfo;
		option.schemaName = schemaName;
		option.tableName = getTableNameHook();
		option.columns = getColumns();		
		option.whereClause = getWhereClause(getLookupTableHook(), option.recordInfo);
		option.resultParser = getResultParserHook();
		option.stmtParamTranslator = getParamTranslatorHook();
		option.joins = getJoinsHook(option.recordInfo);
		
		return option;
	}
	
	
	
	private List<DaoColumn> getColumns() {
		String tableName = getLookupTableHook();
		return DaoDbTableColumnAll.getTableColumnsAsList(tableName);
	}
	
	
	
	private String getWhereClause(String tableName, T recordInfo) {
		T recordCopy = makeClone(recordInfo);
		String tableCopy = tableName;
		
		return buildWhereClauseHook(tableCopy, recordCopy);
	}	
	
	
	
	private DaoStmt<T> buildHelper(DaoStmtOption<T> option) {
		DaoOperation operation = getOperationHook();
		
		return new DaoStmtHelper<>(operation, option, this.getClass());
	}
	
	
	
	protected String getLookupTableHook() {
		return getTableNameHook();
	}	
	
	
	
	protected String getTableNameHook() {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected String buildWhereClauseHook(String tableName, T recordInfo) {
		//Template method: default behavior
		return null;
	}
	
	
	
	protected DaoResultParser<T> getResultParserHook() {
		//Template method: default behavior
		return null;
	}
	
	
	
	protected DaoStmtParamTranslator<T> getParamTranslatorHook() {
		//Template method: default behavior
		return null;
	}
	
	
	
	protected DaoOperation getOperationHook() {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	protected List<DaoJoin> getJoinsHook(T recordInfo) {
		//Template method: default behavior
		DaoJoin singleJoin = getJoinHook(recordInfo);
		
		if (singleJoin == null)
			return null;		
		
		List<DaoJoin> joins = new ArrayList<>();	
		joins.add(singleJoin);
		
		return joins;
	}
	
	
	
	protected DaoJoin getJoinHook(T recordInfo) {
		//Template method: default behavior
		return null;
	}	

	
	
	@Override public boolean checkStmtGeneration() {
		checkState();
		return helper.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		checkState();
		helper.executeStmt();
	}

	
	
	@Override public List<T> getResultset() {
		checkState();
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		closeHelper();
		clear();
	}
	
	
	
	private void closeHelper() {
		if (helper == null)
			return;
		
		helper.close();
	}
	
	
	
	private void clear() {
		helper = DefaultValue.object();
	}
	
	
	
	@SuppressWarnings("unchecked")
	private T makeClone(T recordInfo) {
		try {
			return (T) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new InternalError(e);
		}
	}
	
	
	
	private void checkState() {
		if (helper == null) {
			logException(new NullPointerException(SystemMessage.OBJECT_IS_CLOSED));
			throw new NullPointerException(SystemMessage.OBJECT_IS_CLOSED);
		}
	}
	
	
	
	private void checkArgument(Connection conn, T recordInfo, String schemaName) {
		if (conn == null) {
			logException(new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);		
		}

		
		if (schemaName == null) {
			logException(new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	protected void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}	
}
