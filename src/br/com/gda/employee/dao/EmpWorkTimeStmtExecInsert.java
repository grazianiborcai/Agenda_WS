package br.com.gda.employee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlStmtExecutor;

public final class EmpWorkTimeStmtExecInsert implements SqlStmtExecutor {
	private List<EmpWorkTimeStmtInsert> sqlStatements = new ArrayList<>();
	private List<EmpStmtOption> options = new ArrayList<>();
	
	
	public EmpWorkTimeStmtExecInsert(List<EmpStmtOption> options) {
		if (options == null) 
			throw new NullPointerException("options argument is null");
		
		if (options.isEmpty())
			throw new IllegalArgumentException("options argument is empty");		
		
		
		makeDefensiveCopy(options);	
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
	
	
		
	@Override public void executeStmt() throws SQLException {
		requestPrepareStatement();
		requestCheckStmtGeneration();
		requestGenerateStmt();
		requestExecuteStmt();
	}
	
	
	
	private void requestPrepareStatement() {
		for (EmpStmtOption eachOption : this.options) {
			EmpWorkTimeStmtInsert sqlStatement = new EmpWorkTimeStmtInsert(eachOption);
			this.sqlStatements.add(sqlStatement);
		}
	}
	
	
	
	private void requestCheckStmtGeneration() {
		//TODO: Seria interessante que a exceção pudesse ser a mesma da origem. Verifica a adição de um método void de verificação que dispara exceção original 
		for (EmpWorkTimeStmtInsert eachStatement : this.sqlStatements) {
			if (! eachStatement.checkStmtGeneration())
				throw new IllegalStateException(SystemMessage.REQUEST_FAILED);
		}
	}
	
	
		
	private void requestGenerateStmt() throws SQLException {
		for (EmpWorkTimeStmtInsert eachStatement : this.sqlStatements) {
			eachStatement.generateStmt();
		}
	}
	
	
	
	private void requestExecuteStmt()  throws SQLException {
		for (EmpWorkTimeStmtInsert eachStatement : this.sqlStatements) {
			eachStatement.executeStmt();
		}
	}
}