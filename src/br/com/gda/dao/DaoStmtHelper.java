package br.com.gda.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public final class DaoStmtHelper<T> implements DaoStmt<T> {
	private DaoOperation operation;
	private DaoStmtOption<T> option;
	private String stmtSkeleton;
	private PreparedStatement stmt;
	ResultSet stmtResultSet;
	private List<T> resultset;
	
	
	public DaoStmtHelper(DaoOperation operation, DaoStmtOption<T> option) {
		if (operation == null)
			throw new NullPointerException("operation" + SystemMessage.NULL_ARGUMENT);
		
		if (option == null)
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);

		if (option.conn == null)
			throw new NullPointerException("option.conn" + SystemMessage.NULL_ARGUMENT);
		
		if (option.schemaName == null)
			throw new NullPointerException("option.schemaName" + SystemMessage.NULL_ARGUMENT);
		
		
		this.operation = operation;
		makeDefensiveCopy(option);		
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void makeDefensiveCopy(DaoStmtOption<T> option) {
		try {
			this.option = (DaoStmtOption<T>) option.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
		
	
	
	@Override public void generateStmt() throws SQLException {
		buildStmtSkeleton();
		createStmt();
		translateStmtParam();
	}
	
	
	
	private void buildStmtSkeleton() {
		DaoStmtBuilderOption builderOption = new DaoStmtBuilderOption();
		builderOption.columns = this.option.columns;
		builderOption.schemaName = this.option.schemaName;
		builderOption.tableName = this.option.tableName;
		builderOption.whereClause = this.option.whereClause;
		builderOption.joins = this.option.joins;
		
		DaoStmtBuilder builder = this.operation.factorySqlStmtBuilder(builderOption);
		this.stmtSkeleton = builder.generatedStatement();
	}
	
	
	
	private void createStmt() throws SQLException {
		this.stmt = this.option.conn.prepareStatement(this.stmtSkeleton);
	}
	
	
	
	private void translateStmtParam() throws SQLException {
		if (option.stmtParamTranslator != null) 
			this.stmt = option.stmtParamTranslator.translateStmtParam(stmt, option.recordInfo);
	}
	
	

	@Override public boolean checkStmtGeneration() {
		return tryToCheckStmtGeneration();
	}
	
	
	
	private boolean tryToCheckStmtGeneration() {
		try {
			checkConnection();
			checkStmtSkeleton();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	private void checkConnection() throws SQLException {
		PreparedStatement tester = this.option.conn.prepareStatement("SELECT 1;");
		tester.executeQuery();
	}	
	
	
	
	private void checkStmtSkeleton() throws Exception {
		if (this.stmtSkeleton == null)
			buildStmtSkeleton();
		
		if (this.stmtSkeleton == null)
			throw new IllegalStateException(SystemMessage.ERROR_CREATING_SKELETON_STATEMENT);
	}	
	
	

	@Override public void executeStmt() throws SQLException {
		execute();
		parseResultSet();
	}
	
	
	
	private void execute() throws SQLException {
		if (operation.isWrittable()) {
			int affectRow = this.stmt.executeUpdate();
			
			if (affectRow <= 0)
				throw new SQLException(SystemMessage.NO_AFFECT_ROWS_IN_DB);
		} else {
			this.stmtResultSet = this.stmt.executeQuery();
		}
	}
	
	
	
	private void parseResultSet() throws SQLException {
		this.resultset = new ArrayList<>();
		
		if (this.option.resultParser == null) {
			this.resultset.add(this.option.recordInfo);
		} else {
			long lastId = getLastInsertId();
			this.resultset = option.resultParser.parseResult(this.stmtResultSet, lastId);
		}
	}
	
	
	
	private long getLastInsertId() throws SQLException {
		PreparedStatement stmtLastId = option.conn.prepareStatement("SELECT LAST_INSERT_ID();");
		ResultSet resultLastId = stmtLastId.executeQuery();
		resultLastId.next();
		return resultLastId.getLong("LAST_INSERT_ID()");		
	}


	
	@Override public List<T> getResultset() {	
		return this.resultset;
	}
		

	
	@Override public String toString() {
		//TODO: realmente necessário ? Pode ser eliminado ? Gera problema se nulo
		return this.stmt.toString();
	}
	
	
	
	@Override public DaoStmt<T> getNewInstance() {
		return new DaoStmtHelper<T>(operation, option);
	}
}
