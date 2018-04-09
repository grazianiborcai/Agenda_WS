package br.com.gda.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public final class SqlStmtHelper<T> implements SqlStmt<T> {
	private SqlOperation operation;
	private SqlStmtOption<T> option;
	private String stmtSkeleton;
	private PreparedStatement stmt;
	ResultSet stmtResultSet;
	private List<T> resultset = new ArrayList<>();
	
	
	public SqlStmtHelper(SqlOperation operation, SqlStmtOption<T> option) {
		if (operation == null)
			throw new NullPointerException("operation" + SystemMessage.NULL_ARGUMENT);
		
		if (option == null)
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		
		if (option.resultParser == null)
			throw new NullPointerException("option.resultParser" + SystemMessage.NULL_ARGUMENT);
		
		
		this.operation = operation;
		makeDefensiveCopy(option);		
	}
	
	
	
	@SuppressWarnings("unchecked")
	private void makeDefensiveCopy(SqlStmtOption<T> option) {
		try {
			this.option = (SqlStmtOption<T>) option.clone();
			
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
		SqlStmtBuilderOption builderOption = new SqlStmtBuilderOption();
		builderOption.columns = this.option.columns;
		builderOption.schemaName = this.option.schemaName;
		builderOption.tableName = this.option.tableName;
		builderOption.whereClause = this.option.whereClause;
		
		SqlStmtBuilder builder = this.operation.factorySqlStmtBuilder(builderOption);
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
			this.stmt.executeUpdate();
		} else {
			this.stmtResultSet = this.stmt.executeQuery();
		}
	}
	
	
	
	private void parseResultSet() throws SQLException {
		this.resultset = new ArrayList<>();
		
		if (this.option.resultParser != null)
			this.resultset = option.resultParser.parseResult(this.stmtResultSet);
	}


	
	@Override public List<T> getResultset() {	
		return this.resultset;
	}
		

	
	@Override public String toString() {
		//TODO: realmente necessário ? Pode ser eliminado ? Gera problema se nulo
		return this.stmt.toString();
	}
	
	
	
	@Override public SqlStmt<T> getNewInstance() {
		return new SqlStmtHelper<T>(operation, option);
	}
}
