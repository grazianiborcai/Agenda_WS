package br.com.mind5.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.info.InfoRecord;


public abstract class DaoStmtTemplate<T extends InfoRecord> implements DaoStmt<T> {
	private DaoStmt<T> stmtSql;
	private DaoStmtOption<T> stmtOption;
	
	
	
	protected DaoStmtTemplate(Connection conn, T recordInfo, String schemaName) {
		stmtOption = buildStmtOption(conn, recordInfo, schemaName);
		stmtSql = buildStmt(stmtOption);
	}
	
	
	
	private DaoStmtOption<T> buildStmtOption(Connection conn, T recordInfo, String schemaName) {
		DaoStmtOption<T> option = new DaoStmtOption<>();
		//TODO: DEFENSIVE COPY
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
		T recordInfoCopy = makeClone(recordInfo);
		String tableNameCopy = tableName;
		
		return buildWhereClauseHook(tableNameCopy, recordInfoCopy);
	}	
	
	
	
	private DaoStmt<T> buildStmt(DaoStmtOption<T> option) {
		return new DaoStmtHelper<>(getOperationHook(), option, this.getClass());
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
	
	
	
	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<T> getResultset() {
		return stmtSql.getResultset();
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
	
	
	
	protected void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
