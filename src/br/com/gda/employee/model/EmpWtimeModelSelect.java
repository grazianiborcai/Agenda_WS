package br.com.gda.employee.model;

import java.util.List;

import br.com.gda.employee.dao.EmpStmtOption;
import br.com.gda.employee.dao.EmpWtimeStmtExecSelect;
import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeModelSelect;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.sql.SqlStmtExecutor;

public final class EmpWtimeModelSelect extends EmpWtimeModelAbstract {
	
	public EmpWtimeModelSelect(EmpWtimeInfo workingTimeInfo) {
		super(workingTimeInfo);
	}
	
	
	
	@Override protected ModelCheckerAbstract<EmpWtimeInfo> buildModelCheckerHook() {
		return new CheckerEmpWtimeModelSelect();
	}
	
	
	
	@Override protected SqlStmtExecutor<EmpWtimeInfo> prepareStatementExecutorHook(List<EmpStmtOption> sqlStmtOptions) {
		return new EmpWtimeStmtExecSelect(sqlStmtOptions);
	}
}
