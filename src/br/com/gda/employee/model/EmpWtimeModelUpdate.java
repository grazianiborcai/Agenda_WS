package br.com.gda.employee.model;

import java.util.List;

import br.com.gda.employee.dao.EmpStmtOption;
import br.com.gda.employee.dao.EmpWtimeStmtExecUpdate;
import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeModelUpdate;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.sql.SqlStmtExecutor;

public final class EmpWtimeModelUpdate extends EmpWtimeModelAbstract {
	
	public EmpWtimeModelUpdate(String incomingData) {
		super(incomingData);
	}
	
	
	
	@Override protected ModelCheckerAbstract<EmpWtimeInfo> buildModelCheckerHook() {
		return new CheckerEmpWtimeModelUpdate();
	}
	
	
	
	@Override protected SqlStmtExecutor<EmpWtimeInfo> prepareStatementExecutorHook(List<EmpStmtOption> sqlStmtOptions) {
		return new EmpWtimeStmtExecUpdate(sqlStmtOptions);
	}
	
	
	
	@Override protected List<EmpWtimeInfo> buildResultsetHook(List<EmpWtimeInfo> workingTimeInfos) {
		return workingTimeInfos;
	}
}
