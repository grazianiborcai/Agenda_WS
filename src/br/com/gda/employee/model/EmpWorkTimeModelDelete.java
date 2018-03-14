package br.com.gda.employee.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.dao.EmpWorkTimeStmtExecDelete;
import br.com.gda.employee.info.EmpWorkTimeInfo;

public final class EmpWorkTimeModelDelete extends EmpWorkTimeModelAbstract {

	public EmpWorkTimeModelDelete(EmpWorkTimeInfo workingTimeInfo) {
		super(workingTimeInfo);
	}
	
	
	
	@Override protected void prepareStatementExecutorHook() {
		this.sqlStmtExecutor = new EmpWorkTimeStmtExecDelete(this.sqlStmtOptions);
	}
	
	
	
	@Override 	protected List<EmpWorkTimeInfo> buildResultsetHook() {
		List<EmpWorkTimeInfo> emptyResult = new ArrayList<>();
		return emptyResult;
	}
}
