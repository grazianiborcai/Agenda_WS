package br.com.mind5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class DaoStmtHelper<T extends InfoRecord> implements DaoStmt<T> {
	private DaoOperation operation;
	private DaoStmtOption<T> option;
	private PreparedStatement stmt;
	private ResultSet stmtResultSet;
	private List<T> resultset;
	private Class<?> childClass;
	
	
	public DaoStmtHelper(DaoOperation stmtOperation, DaoStmtOption<T> stmtOption, Class<?> clazz) {
		checkArgument(stmtOperation, stmtOption, clazz);	
		clear();
		
		operation = stmtOperation;
		childClass = clazz;		
		option = makeClone(stmtOption);
		
		stmt = generateStmt(option, stmtOperation);
	}
	
	
	
	private PreparedStatement generateStmt(DaoStmtOption<T> stmtOption, DaoOperation stmtOperation) {
		String skeleton = buildStmtSkeleton(stmtOption, operation);
		return tryToGenerateStmt(skeleton, stmtOption);
	}
	
	
	
	private String buildStmtSkeleton(DaoStmtOption<T> stmtOption, DaoOperation stmtOperation) {
		DaoStmtBuilderOption builderOption = new DaoStmtBuilderOption();
		
		builderOption.columns = stmtOption.columns;
		builderOption.schemaName = stmtOption.schemaName;
		builderOption.tableName = stmtOption.tableName;
		builderOption.whereClause = stmtOption.whereClause;
		builderOption.joins = stmtOption.joins;
		
		DaoStmtBuilder builder = stmtOperation.factorySqlStmtBuilder(builderOption, childClass);
		return builder.buildStmt();
	}
	
	
	
	private PreparedStatement tryToGenerateStmt(String skeleton, DaoStmtOption<T> option) {
		PreparedStatement result = null;		
		
		try {
			result = prepareStmt(option.conn, option.schemaName, skeleton);
			result = translateStmtParam(option.stmtParamTranslator, result, option.recordInfo);
			
		} catch (SQLException e) {
			logException(e);
		}
		
		return result;
	}
	
	
	
	private PreparedStatement prepareStmt(Connection stmtConn, String stmSchema, String stmtSkeleton) throws SQLException {
		stmtConn.setCatalog(stmSchema);
		return stmtConn.prepareStatement(stmtSkeleton);
	}
	
	
	
	private PreparedStatement translateStmtParam(DaoStmtParamTranslator<T> stmtTranslator, PreparedStatement stmtSql, T recordInfo) throws SQLException {
		if (stmtTranslator != null) 
			return stmtTranslator.translateStmtParam(stmtSql, recordInfo);
		
		return stmtSql;
	}	

	
		
	@Override public void executeStmt() throws SQLException {
		checkBeforeExecution();		
		
		stmtResultSet = execute(operation, stmt);
		resultset = parseResultSet(stmtResultSet, option.resultParser, option.recordInfo);
		
		close(stmt, stmtResultSet);
	}
	
	
	
	private void checkBeforeExecution() {
		if (checkStmtGeneration() == false) {
			logException(new NullPointerException(SystemMessage.OBJ_NOT_INITIALIED));
			throw new NullPointerException(SystemMessage.OBJ_NOT_INITIALIED);
		}
	}
	
	

	@Override public boolean checkStmtGeneration() {
		if (stmt == null)
			return false;
		
		return true;
	}	
	
	
	
	private ResultSet execute(DaoOperation stmtOperation, PreparedStatement sqlStmt) throws SQLException {
		if (stmtOperation.isWritable()) {
			int affectRow = sqlStmt.executeUpdate();
			checkAffectedRow(affectRow);
			return null;
		} 
			
		return sqlStmt.executeQuery();
	}
	
	
	
	private List<T> parseResultSet(ResultSet sqlResult, DaoResultParser<T> parser, T recordInfo) throws SQLException {
		List<T> results = new ArrayList<>();
		
		if (parser == null) {
			results.add(recordInfo);
		} else {
			long lastId = getLastInsertId();
			results = parser.parseResult(recordInfo, sqlResult, lastId);
		}
		
		return results;
	}
	
	
	
	private long getLastInsertId() throws SQLException {
		PreparedStatement stmtLastId = option.conn.prepareStatement("SELECT LAST_INSERT_ID();");
		ResultSet resultLastId = stmtLastId.executeQuery();
		resultLastId.next();
		return resultLastId.getLong("LAST_INSERT_ID()");		
	}
	
	
	
	@Override public void close() {
		tryToClose(stmt, stmtResultSet);
		clear();
	}
	
	
	
	private void tryToClose(PreparedStatement sqlStmt, ResultSet sqlResultSet) {
		try {
			close(stmt, stmtResultSet);
			
		} catch (SQLException e) {
			logException(e);
		}
	}
	
	
	
	private void close(PreparedStatement sqlStmt, ResultSet sqlResultSet) throws SQLException {
		closeResultSet(sqlResultSet);
		closeStatement(sqlStmt);
	}
	
	
	
	private void closeResultSet(ResultSet sqlResultSet) throws SQLException {
		if (sqlResultSet == null)
			return;
		
		if (sqlResultSet.isClosed())
			return;
		
		sqlResultSet.close();
		sqlResultSet = null;
	}
	
	
	
	private void closeStatement(PreparedStatement sqlStmt) throws SQLException {
		if (sqlStmt == null)
			return;
		
		if (sqlStmt.isClosed())
			return;
		
		sqlStmt.close();
		sqlStmt = null;
	}
	
	
	
	private void clear() {
		operation = DefaultValue.object();
		option = DefaultValue.object();
		stmt = DefaultValue.object();
		stmtResultSet = DefaultValue.object();
		resultset = DefaultValue.list();
	}


	
	@Override public List<T> getResultset() {	
		hasResult();
		return makeClone(resultset);
	}
	
	
	
	private void hasResult() {
		if (resultset == null) {
			logException(new NullPointerException(SystemMessage.OBJ_NOT_INITIALIED));
			throw new NullPointerException(SystemMessage.OBJ_NOT_INITIALIED);
		}
	}
	
	
	
	private List<T> makeClone(List<T> sources) {
		return CloneUtil.cloneRecords(sources, childClass);
	}
	
	
	
	@SuppressWarnings("unchecked")
	private DaoStmtOption<T> makeClone(DaoStmtOption<T> stmtOption) {
		try {
			return (DaoStmtOption<T>) stmtOption.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new InternalError(e);
		}
	}
	
	
	
	private void checkAffectedRow(int affectRow) throws SQLException {
		if (affectRow <= 0) {
			logException(new SQLException(SystemMessage.NO_AFFECT_ROWS_IN_DB));
			throw new SQLException(SystemMessage.NO_AFFECT_ROWS_IN_DB);
		}
	}	
	
	
	
	private void checkArgument(DaoOperation operation, DaoStmtOption<T> option, Class<?> clazz) {
		if (operation == null) {
			logException(new NullPointerException("operation" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("operation" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option == null) {
			logException(new NullPointerException("option" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		}
		

		if (option.conn == null) {
			logException(new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (option.schemaName == null) {
			logException(new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
		}	
	}	
	
	
		
	private void logException(Exception e) {
		Class<?> clazz = childClass;
		
		if (clazz == null)
			clazz = this.getClass();
		
		SystemLog.logError(clazz, e);
	}		
}
