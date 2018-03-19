package br.com.gda.employee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExecutor;

abstract class EmpWtimeStmtExecAbstract implements SqlStmtExecutor<EmpWtimeInfo> {
	protected List<SqlStmt<EmpWtimeInfo>> sqlStatements;
	protected List<EmpStmtOption> options = new ArrayList<>();
	protected List<EmpWtimeInfo> resultset = new ArrayList<>();
	
	
	public EmpWtimeStmtExecAbstract(List<EmpStmtOption> options) {
		if (options == null) 
			throw new NullPointerException("options" + SystemMessage.NULL_ARGUMENT);
		
		if (options.isEmpty())
			throw new IllegalArgumentException("options" + SystemMessage.EMPTY_ARGUMENT);		
		
		
		makeDefensiveCopy(options);	
		setRecordMode();
	}
	
	
	
	private void makeDefensiveCopy(List<EmpStmtOption> options) {
		try {
			for (EmpStmtOption eachOption : options) {
				EmpStmtOption cloneOption = (EmpStmtOption) eachOption.clone();			
				this.options.add(cloneOption);
			}
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalArgumentException(e);
		}	
	}
	
	
	
	private void setRecordMode() {
		for (EmpStmtOption eachOption : this.options) {
			eachOption.workingTime.recordMode = setRecordModeHook();
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
	
	
	
	protected List<SqlStmt<EmpWtimeInfo>> requestPrepareStatementHook() {
		//Template method: to be overridden by subclasses
		return new ArrayList<>();
	}
	
	
	
	protected void requestCheckStmtGeneration() {
		//TODO: Seria interessante que a exceção pudesse ser a mesma da origem. Verifica a adição de um método void de verificação que dispara exceção original 
		for (SqlStmt<EmpWtimeInfo> eachStatement : this.sqlStatements) {
			if (! eachStatement.checkStmtGeneration())
				throw new IllegalStateException(SystemMessage.REQUEST_FAILED);
		}
	}
	
	
	
	protected void requestGenerateStmt() throws SQLException {
		for (SqlStmt<EmpWtimeInfo> eachStatement : this.sqlStatements) {
			eachStatement.generateStmt();			
		}
	}
	
	
	
	protected void requestExecuteStmt()  throws SQLException {
		for (SqlStmt<EmpWtimeInfo> eachStatement : this.sqlStatements) {
			eachStatement.executeStmt();
			addToResultset(eachStatement.getResultset());
		}
	}
	
	
	
	private void addToResultset(List<EmpWtimeInfo> stmtResults) {
		for (EmpWtimeInfo eachResult : stmtResults) {
			this.resultset.add(eachResult);
		}
	}
	
	
	
	public List<EmpWtimeInfo> getResultset() {
		try {
			return tryToGetResultset();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<EmpWtimeInfo> tryToGetResultset() throws CloneNotSupportedException {
		List<EmpWtimeInfo> results = new ArrayList<>();
		
		for (EmpWtimeInfo eachResult : this.resultset) {
			EmpWtimeInfo resultCloned = (EmpWtimeInfo) eachResult.clone();
			results.add(resultCloned);
		}
		
		return results;
	}
}
