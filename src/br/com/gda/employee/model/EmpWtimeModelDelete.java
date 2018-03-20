package br.com.gda.employee.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.dao.EmpStmtOption;
import br.com.gda.employee.dao.EmpWtimeStmtExecDelete;
import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeModelDelete;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.sql.SqlStmtExecutor;

public final class EmpWtimeModelDelete extends EmpWtimeModelAbstract {

	public EmpWtimeModelDelete(EmpWtimeInfo workingTimeInfo) {
		super(workingTimeInfo);
	}
	
	
	
	@Override protected ModelCheckerAbstract<EmpWtimeInfo> buildModelCheckerHook() {
		return new CheckerEmpWtimeModelDelete();
	}
	
	
	
	@Override protected SqlStmtExecutor<EmpWtimeInfo> prepareStatementExecutorHook(List<EmpStmtOption> sqlStmtOptions) {
		return new EmpWtimeStmtExecDelete(sqlStmtOptions);
	}
	
	
	
	@Override protected List<EmpWtimeInfo> buildResultsetHook(List<EmpWtimeInfo> workingTimeInfos) {
		List<EmpWtimeInfo> emptyResult = new ArrayList<>();
		emptyResult.add(new EmpWtimeInfo());
		return emptyResult;
	}
}
