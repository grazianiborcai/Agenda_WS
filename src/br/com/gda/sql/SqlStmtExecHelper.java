package br.com.gda.sql;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public final class SqlStmtExecHelper<T> implements SqlStmtExec<T> {
	private List<SqlStmt<T>> sqlStatements = new ArrayList<>();
	private List<T> resultset = new ArrayList<>();
	
	
	public SqlStmtExecHelper(List<SqlStmt<T>> sqlStatements) {
		if (sqlStatements == null) 
			throw new NullPointerException("sqlStatements" + SystemMessage.NULL_ARGUMENT);
		
		if (sqlStatements.isEmpty())
			throw new IllegalArgumentException("recordInfos" + SystemMessage.EMPTY_ARGUMENT);

		this.sqlStatements = sqlStatements;	
	}
	


	@Override public void executeStmt() throws SQLException {
		requestCheckStmtGeneration();
		requestGenerateStmt();
		requestExecuteStmt();
	}
	
	
	
	private void requestCheckStmtGeneration() throws SQLException { 
		for (SqlStmt<T> eachStatement : this.sqlStatements) {
			if (! eachStatement.checkStmtGeneration()) {
				eachStatement.generateStmt();
				throw new IllegalStateException(SystemMessage.REQUEST_FAILED);
			}
		}
	}
	
	
	
	private void requestGenerateStmt() throws SQLException {
		for (SqlStmt<T> eachStatement : this.sqlStatements) {
			eachStatement.generateStmt();			
		}
	}
	
	
	
	private void requestExecuteStmt() throws SQLException {
		for (SqlStmt<T> eachStatement : this.sqlStatements) {
			eachStatement.executeStmt();
			addToResultset(eachStatement.getResultset());
		}
	}
	
	
	
	private void addToResultset(List<T> stmtResults) {
		for (T eachResult : stmtResults) {
			this.resultset.add(eachResult);
		}
	}
	
	

	@Override
	public List<T> getResultset() {
		try {
			return tryToGetResultset();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<T> tryToGetResultset() throws CloneNotSupportedException {
		try { 
			List<T> results = new ArrayList<>();
			
			for (T eachResult : this.resultset) {
				@SuppressWarnings("unchecked")
				T resultCloned = (T) eachResult.getClass().getMethod("clone").invoke(eachResult);
				results.add(resultCloned);
			}
			
			return results;
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new CloneNotSupportedException();
		} 	
	}
}
