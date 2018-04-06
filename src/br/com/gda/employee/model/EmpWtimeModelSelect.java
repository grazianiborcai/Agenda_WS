package br.com.gda.employee.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.dao.EmpWtimeStmtExecSelect;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeMandatoryRead;
import br.com.gda.model.ModelAbstract;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpWtimeModelSelect extends ModelAbstract<EmpWTimeInfo> {
	
	public EmpWtimeModelSelect(EmpWTimeInfo workingTimeInfo) {
		super(EmpWTimeInfo.class, workingTimeInfo);
	}
	
	
	
	@Override protected ModelCheckerAbstract<EmpWTimeInfo> buildModelCheckerHook() {
		List<ModelCheckerAbstract<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelCheckerAbstract<EmpWTimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	@Override protected SqlStmtExec<EmpWTimeInfo> prepareStatementExecutorHook(List<SqlStmtExecOption<EmpWTimeInfo>> sqlStmtOptions) {
		return new EmpWtimeStmtExecSelect(sqlStmtOptions);
	}
}
