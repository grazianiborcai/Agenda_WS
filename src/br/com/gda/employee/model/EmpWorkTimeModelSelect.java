package br.com.gda.employee.model;

import java.util.List;

import br.com.gda.employee.dao.EmpWorkTimeStmtExecSelect;
import br.com.gda.employee.info.EmpWorkTimeInfo;

public final class EmpWorkTimeModelSelect extends EmpWorkTimeModelAbstract {
	
	public EmpWorkTimeModelSelect(EmpWorkTimeInfo workingTimeInfo) {
		super(workingTimeInfo);
	}
	
	
	
	@Override protected void prepareStatementExecutorHook() {
		this.sqlStmtExecutor = new EmpWorkTimeStmtExecSelect(this.sqlStmtOptions);
	}
	
	
	
	@Override 	protected List<EmpWorkTimeInfo> buildResultsetHook() {
		return this.sqlStmtExecutor.getResultset();
	}
}
