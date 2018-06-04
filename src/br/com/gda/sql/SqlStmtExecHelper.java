package br.com.gda.sql;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

public final class SqlStmtExecHelper<T> implements SqlStmtExec<T> {
	private List<SqlStmt<T>> sqlStatements = new ArrayList<>();
	private List<T> resultset = new ArrayList<>();
	
	
	
	public SqlStmtExecHelper(List<SqlStmtExecOption<T>> options, Class<? extends SqlStmt<T>> classOfStmt, Class<T> classOfT) {
		checkArgument(options, classOfStmt, classOfT);
		buildStmt(options, classOfStmt, classOfT);
	}
	
	
	
	private void checkArgument(List<SqlStmtExecOption<T>> options, Class<? extends SqlStmt<T>> classOfStmt, Class<T> classOfT) {
		if (options == null) 
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		
		if (classOfStmt == null) 
			throw new NullPointerException("classOfStmt" + SystemMessage.NULL_ARGUMENT);
		
		
		if (classOfT == null) 
			throw new NullPointerException("classOfT" + SystemMessage.NULL_ARGUMENT);
		
		
		if (options.isEmpty())
			throw new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT);
		
		
		checkEachOption(options);
	}
	
	
	
	private void checkEachOption(List<SqlStmtExecOption<T>> options) {
		for (SqlStmtExecOption<T> eachOption: options) {
			if (eachOption.recordInfo == null)
				throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
			
			if (eachOption.schemaName == null)
				throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
			
			if (eachOption.conn == null)
				throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void buildStmt(List<SqlStmtExecOption<T>> options, Class<? extends SqlStmt<T>> classOfStmt, Class<T> classOfT) {
		for (SqlStmtExecOption<T> eachOption : options) {
			SqlStmt<T> sqlStatement = getNewInstanceOfStmt(eachOption, classOfStmt, classOfT);
			this.sqlStatements.add(sqlStatement);
		}
		
		
		if (sqlStatements.isEmpty())
			throw new IllegalArgumentException("sqlStatements" + SystemMessage.EMPTY_ARGUMENT);
	}
	
	
	
	private SqlStmt<T> getNewInstanceOfStmt(SqlStmtExecOption<T> option, Class<? extends SqlStmt<T>> classOfStmt, Class<T> classOfT) {
		try {	
			Constructor<? extends SqlStmt<T>> constructor = classOfStmt.getConstructor(Connection.class, classOfT, String.class);
			return (SqlStmt<T>) constructor.newInstance(option.conn, option.recordInfo, option.schemaName); 
			
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	
	//TODO: remover esse constructor e adaptar classes clientes que a utilizam
	public SqlStmtExecHelper(List<SqlStmt<T>> sqlStatements) {
		if (sqlStatements == null) 
			throw new NullPointerException("sqlStatements" + SystemMessage.NULL_ARGUMENT);
		
		if (sqlStatements.isEmpty())
			throw new IllegalArgumentException("sqlStatements" + SystemMessage.EMPTY_ARGUMENT);

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
	
	

	@Override public List<T> getResultset() {
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
