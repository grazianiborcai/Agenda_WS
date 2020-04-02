package br.com.mind5.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class DaoStmtExecHelper<T extends InfoRecord> implements DaoStmtExec<T> {
	private List<DaoStmt<T>> sqlStmts;
	private List<T> resultset;
	private Class<?> stmtClass;	
	
	
	public DaoStmtExecHelper(List<DaoStmtExecOption<T>> options, Class<? extends DaoStmt<T>> classOfStmt, Class<T> classOfT) {
		checkArgument(options, classOfStmt, classOfT);		
		clear();
		
		List<DaoStmtExecOption<T>> copyOptions = makeClone(options);		
		sqlStmts = buildStmt(copyOptions, classOfStmt, classOfT);
	}
		
		
	
	private List<DaoStmt<T>> buildStmt(List<DaoStmtExecOption<T>> options, Class<? extends DaoStmt<T>> classOfStmt, Class<T> classOfT) {
		List<DaoStmt<T>> results = new ArrayList<>();
		
		for (DaoStmtExecOption<T> eachOption : options) {
			DaoStmt<T> sqlStatement = getNewInstanceOfStmt(eachOption, classOfStmt, classOfT);
			results.add(sqlStatement);
		}
		
		checkBuild(results);
		return results;
	}
	
	
	
	private DaoStmt<T> getNewInstanceOfStmt(DaoStmtExecOption<T> option, Class<? extends DaoStmt<T>> classOfStmt, Class<T> classOfT) {
		try {	
			Constructor<? extends DaoStmt<T>> constructor = classOfStmt.getConstructor(Connection.class, classOfT, String.class);
			return (DaoStmt<T>) constructor.newInstance(option.conn, option.recordInfo, option.schemaName); 
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalArgumentException(e);
		}
	}
	


	@Override public void executeStmt() throws SQLException {
		checkStmtGeneration(sqlStmts);
		resultset = executeStmt(sqlStmts);
		closeStmts(sqlStmts);
	}
	
	
	
	private void checkStmtGeneration(List<DaoStmt<T>> stmts) throws SQLException { 
		for (DaoStmt<T> eachStmt : stmts) {
			if (eachStmt.checkStmtGeneration() == false) {
				logException(new IllegalStateException(SystemMessage.REQUEST_FAILED));
				throw new IllegalStateException(SystemMessage.REQUEST_FAILED);
			}
		}
	}
	
	
	
	private List<T> executeStmt(List<DaoStmt<T>> stmts) throws SQLException {
		List<T> results = new ArrayList<>();
		
		for (DaoStmt<T> eachStmt : stmts) {
			eachStmt.executeStmt();
			results = addToResults(eachStmt, results);
		}
		
		return results;
	}
	
	
	
	private List<T> addToResults(DaoStmt<T> stmt, List<T> results) {
		List<T> stmtResults = stmt.getResultset();
		
		for (T eachResult : stmtResults) {
			results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	public void close() {
		closeStmts(sqlStmts);
		clear();
	}
	
	
	
	private void closeStmts(List<DaoStmt<T>> stmts) {
		for (DaoStmt<T> eachStmt : stmts) {
			eachStmt.close();
		}
	}
	
	
	
	private void clear() {
		sqlStmts = DefaultValue.list();
		resultset = DefaultValue.list();
	}
	
	

	@Override public List<T> getResultset() {
		try {
			return tryToGetResultset();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<T> tryToGetResultset() throws CloneNotSupportedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<T> results = new ArrayList<>();
		
		for (T eachResult : this.resultset) {
			@SuppressWarnings("unchecked")
			T resultCloned = (T) eachResult.getClass().getMethod("clone").invoke(eachResult);
			results.add(resultCloned);
		}
		
		return results;
	}
	
	
	
	private void checkArgument(List<DaoStmtExecOption<T>> options, Class<? extends DaoStmt<T>> classOfStmt, Class<T> classOfT) {
		if (options == null) {
			logException(new NullPointerException("options" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (classOfStmt == null) {
			logException(new NullPointerException("classOfStmt" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("classOfStmt" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (classOfT == null) {
			logException(new NullPointerException("classOfT" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("classOfT" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (options.isEmpty()) {
			logException(new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT);
		}
		
		
		checkEachOption(options);
	}
	
	
	
	private void checkEachOption(List<DaoStmtExecOption<T>> options) {
		for (DaoStmtExecOption<T> eachOption: options) {
			if (eachOption.recordInfo == null) {
				logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
				throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
			}
			
			
			if (eachOption.schemaName == null) {
				logException(new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT));
				throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);
			}
			
			
			if (eachOption.conn == null) {
				logException(new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT));
				throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);
			}
		}
	}	
	
	
	
	private void checkBuild(List<DaoStmt<T>> stmts) {
		if (stmts.isEmpty()) {
			logException(new NullPointerException("sqlStatements" + SystemMessage.EMPTY_ARGUMENT));
			throw new IllegalArgumentException("sqlStatements" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	private List<DaoStmtExecOption<T>> makeClone(List<DaoStmtExecOption<T>> options) {
		List<DaoStmtExecOption<T>> results = new ArrayList<>();
		
		for (DaoStmtExecOption<T> eachOption : options) {
			DaoStmtExecOption<T> eachResult = makeClone(eachOption);
			results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private DaoStmtExecOption<T> makeClone(DaoStmtExecOption<T> option) {
		try {
			if (option == null)
				return null;
			
			return (DaoStmtExecOption<T>) option.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	protected void logException(Exception e) {
		Class<?> clazz = stmtClass;
		
		if (clazz == null)
			clazz = this.getClass();
		
		SystemLog.logError(clazz, e);
	}	
}
