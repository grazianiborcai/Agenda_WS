package br.com.gda.employee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtExecutor;

abstract class EmpWorkTimeStmtExecAbstract implements SqlStmtExecutor<EmpWorkTimeInfo> {
	protected List<SqlStmt<EmpWorkTimeInfo>> sqlStatements;
	protected List<EmpStmtOption> options = new ArrayList<>();
	protected List<EmpWorkTimeInfo> resultset = new ArrayList<>();
	
	
	public EmpWorkTimeStmtExecAbstract(List<EmpStmtOption> options) {
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
	
	
	
	protected List<SqlStmt<EmpWorkTimeInfo>> requestPrepareStatementHook() {
		//Template method: to be overridden by subclasses
		return new ArrayList<>();
	}
	
	
	
	protected void requestCheckStmtGeneration() {
		//TODO: Seria interessante que a exceção pudesse ser a mesma da origem. Verifica a adição de um método void de verificação que dispara exceção original 
		for (SqlStmt<EmpWorkTimeInfo> eachStatement : this.sqlStatements) {
			if (! eachStatement.checkStmtGeneration())
				throw new IllegalStateException(SystemMessage.REQUEST_FAILED);
		}
	}
	
	
	
	protected void requestGenerateStmt() throws SQLException {
		for (SqlStmt<EmpWorkTimeInfo> eachStatement : this.sqlStatements) {
			eachStatement.generateStmt();			
		}
	}
	
	
	
	protected void requestExecuteStmt()  throws SQLException {
		for (SqlStmt<EmpWorkTimeInfo> eachStatement : this.sqlStatements) {
			eachStatement.executeStmt();
			addToResultset(eachStatement.getResultset());
		}
	}
	
	
	
	private void addToResultset(List<EmpWorkTimeInfo> stmtResults) {
		for (EmpWorkTimeInfo eachResult : stmtResults) {
			this.resultset.add(eachResult);
		}
	}
	
	
	
	public List<EmpWorkTimeInfo> getResultset() {
		try {
			return tryToGetResultset();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<EmpWorkTimeInfo> tryToGetResultset() throws CloneNotSupportedException {
		List<EmpWorkTimeInfo> results = new ArrayList<>();
		
		for (EmpWorkTimeInfo eachResult : this.resultset) {
			EmpWorkTimeInfo resultCloned = (EmpWorkTimeInfo) eachResult.clone();
			results.add(resultCloned);
		}
		
		return results;
	}
}
