package br.com.mind5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
//TODO: trocar por Template ?
public final class DaoStmtHelperV2<T> implements DaoStmt<T> {
	private DaoOperation operation;
	private DaoStmtOptionV2<T> option;
	private String skeleton;
	private PreparedStatement stmt;
	private ResultSet stmtResultSet;
	private List<T> resultset;
	private Class<?> childClass;
	
	
	public DaoStmtHelperV2(DaoOperation stmtOperation, DaoStmtOptionV2<T> stmtOption, Class<?> clazz) {
		checkArgument(stmtOperation, stmtOption, clazz);		
		
		operation = stmtOperation;
		childClass = clazz;
		option = makeDefensiveCopy(stmtOption);	
	}
		
	
	
	@Override public void generateStmt() throws SQLException {
		if (isGenerated() == false) {		
			skeleton = buildStmtSkeleton(option, operation);
			stmt = prepareStmt(option.conn, option.schemaName, skeleton);
			stmt = translateStmtParam(option.stmtParamTranslator, stmt, option.recordInfo);
		}
	}
	
	
	
	private String buildStmtSkeleton(DaoStmtOptionV2<T> stmtOption, DaoOperation stmtOperation) {
		DaoStmtBuilderOption builderOption = new DaoStmtBuilderOption();
		builderOption.columns = stmtOption.columns;
		builderOption.schemaName = stmtOption.schemaName;
		builderOption.tableName = stmtOption.tableName;
		builderOption.whereClause = stmtOption.whereClause;
		builderOption.joins = stmtOption.joins;
		
		DaoStmtBuilder builder = stmtOperation.factorySqlStmtBuilder(builderOption, childClass);
		return builder.buildStmt();
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
	
	

	@Override public boolean checkStmtGeneration() {
		return tryToCheckStmtGeneration(option.conn);
	}
	
	
	
	private boolean tryToCheckStmtGeneration(Connection stmtConn) {
		try {
			checkConnection(stmtConn);	
			generateStmt();
			return true;
			
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}
	
	
	
	private void checkConnection(Connection stmtConn) throws SQLException {
		PreparedStatement tester = stmtConn.prepareStatement("SELECT 1;");
		tester.executeQuery();
	}	
	
	

	@Override public void executeStmt() throws SQLException {
		checkBeforeExecution();		
		stmtResultSet = execute(operation, stmt);
		resultset = parseResultSet(stmtResultSet, option.resultParser, option.recordInfo);
	}
	
	
	
	private ResultSet execute(DaoOperation stmtOperation, PreparedStatement sqlStmt) throws SQLException {
		if (stmtOperation.isWritable()) {
			int affectRow = sqlStmt.executeUpdate();
			checkAffectedRow(affectRow);
			return null;
		} 
			
		return sqlStmt.executeQuery();
	}
	
	
	
	private List<T> parseResultSet(ResultSet sqlResult, DaoResultParserV2<T> parser, T recordInfo) throws SQLException {
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


	
	@Override public List<T> getResultset() {	
		checkExecuted();
		return resultset;
	}
	
	
	
	@Override public DaoStmt<T> getNewInstance() {
		return new DaoStmtHelperV2<T>(operation, option, childClass);
	}
	
	
	
	private boolean isGenerated() {
		if(skeleton == null)
			return false;
		
		return true;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private DaoStmtOptionV2<T> makeDefensiveCopy(DaoStmtOptionV2<T> option) {
		try {
			return (DaoStmtOptionV2<T>) option.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}	
	
	
	
	private void checkBeforeExecution() {
		if (isGenerated() == false) {
			logException(new NullPointerException(SystemMessage.OBJ_NOT_INITIALIED));
			throw new NullPointerException(SystemMessage.OBJ_NOT_INITIALIED);
		}
	}
	
	
	
	private void checkExecuted() {
		if (resultset == null) {
			logException(new NullPointerException(SystemMessage.OBJ_NOT_INITIALIED));
			throw new NullPointerException(SystemMessage.OBJ_NOT_INITIALIED);
		}
	}
	
	
	
	private void checkAffectedRow(int affectRow) throws SQLException {
		if (affectRow <= 0) {
			logException(new SQLException(SystemMessage.NO_AFFECT_ROWS_IN_DB));
			throw new SQLException(SystemMessage.NO_AFFECT_ROWS_IN_DB);
		}
	}	
	
	
	
	private void checkArgument(DaoOperation operation, DaoStmtOptionV2<T> option, Class<?> clazz) {
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
		
		Logger logger = LogManager.getLogger(clazz);
		logger.error(e.getMessage(), e);
	}		
}
