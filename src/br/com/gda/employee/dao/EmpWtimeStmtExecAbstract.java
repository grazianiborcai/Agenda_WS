package br.com.gda.employee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExecutor;

abstract class EmpWtimeStmtExecAbstract implements SqlStmtExecutor<EmpWTimeInfo> {
	protected List<SqlStmt<EmpWTimeInfo>> sqlStatements;
	protected List<EmpStmtOption<EmpWTimeInfo>> options = new ArrayList<>();
	protected List<EmpWTimeInfo> resultset = new ArrayList<>();
	
	
	public EmpWtimeStmtExecAbstract(List<EmpStmtOption<EmpWTimeInfo>> options) {
		if (options == null) 
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (options.isEmpty())
			throw new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT);		
		
		
		makeDefensiveCopy(options);	
		setRecordMode();
	}
	
	
	
	private void makeDefensiveCopy(List<EmpStmtOption<EmpWTimeInfo>> options) {
		try {
			for (EmpStmtOption<EmpWTimeInfo> eachOption : options) {
				@SuppressWarnings("unchecked")
				EmpStmtOption<EmpWTimeInfo> cloneOption = (EmpStmtOption<EmpWTimeInfo>) eachOption.clone();			
				this.options.add(cloneOption);
			}
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalArgumentException(e);
		}	
	}
	
	
	
	private void setRecordMode() {
		for (EmpStmtOption<EmpWTimeInfo> eachOption : this.options) {
			eachOption.recordInfo.recordMode = setRecordModeHook();
		}
	}
	
	
	
	protected String setRecordModeHook() {
		//Template method: to be overridden by subclasses
		return RecordMode.RECORD_OK;
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		requestPrepareStatement();
		requestCheckStmtGeneration();
		requestGenerateStmt();
		requestExecuteStmt();
	}
	
	
	
	private void requestPrepareStatement() {
		this.sqlStatements = requestPrepareStatementHook();
	}
	
	
	
	protected List<SqlStmt<EmpWTimeInfo>> requestPrepareStatementHook() {
		//Template method: to be overridden by subclasses
		return new ArrayList<>();
	}
	
	
	
	protected void requestCheckStmtGeneration() {
		//TODO: Seria interessante que a exceção pudesse ser a mesma da origem. Verifica a adição de um método void de verificação que dispara exceção original 
		for (SqlStmt<EmpWTimeInfo> eachStatement : this.sqlStatements) {
			if (! eachStatement.checkStmtGeneration())
				throw new IllegalStateException(SystemMessage.REQUEST_FAILED);
		}
	}
	
	
	
	protected void requestGenerateStmt() throws SQLException {
		for (SqlStmt<EmpWTimeInfo> eachStatement : this.sqlStatements) {
			eachStatement.generateStmt();			
		}
	}
	
	
	
	protected void requestExecuteStmt()  throws SQLException {
		for (SqlStmt<EmpWTimeInfo> eachStatement : this.sqlStatements) {
			eachStatement.executeStmt();
			addToResultset(eachStatement.getResultset());
		}
	}
	
	
	
	private void addToResultset(List<EmpWTimeInfo> stmtResults) {
		for (EmpWTimeInfo eachResult : stmtResults) {
			this.resultset.add(eachResult);
		}
	}
	
	
	
	public List<EmpWTimeInfo> getResultset() {
		try {
			return tryToGetResultset();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<EmpWTimeInfo> tryToGetResultset() throws CloneNotSupportedException {
		List<EmpWTimeInfo> results = new ArrayList<>();
		
		for (EmpWTimeInfo eachResult : this.resultset) {
			EmpWTimeInfo resultCloned = (EmpWTimeInfo) eachResult.clone();
			results.add(resultCloned);
		}
		
		return results;
	}
}
