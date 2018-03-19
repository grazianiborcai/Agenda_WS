package br.com.gda.employee.model;

import java.util.List;

import br.com.gda.employee.dao.EmpStmtOption;
import br.com.gda.employee.dao.EmpWtimeStmtExecInsert;
import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeModelInsert;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.sql.SqlStmtExecutor;

public class EmpWtimeModelInsert extends EmpWtimeModelAbstract {
	
	public EmpWtimeModelInsert(String incomingData) {
		super(incomingData);
	}
	
	
	
	@Override protected ModelCheckerAbstract<EmpWtimeInfo> buildModelCheckerHook() {
		return new CheckerEmpWtimeModelInsert();
	}
	
	
	
	@Override protected SqlStmtExecutor<EmpWtimeInfo> prepareStatementExecutorHook(List<EmpStmtOption> sqlStmtOptions) {
		return new EmpWtimeStmtExecInsert(sqlStmtOptions);
	}
	
	
	
	@Override protected List<EmpWtimeInfo> buildResultsetHook(List<EmpWtimeInfo> workingTimeInfos) {
		return workingTimeInfos;
	}
}