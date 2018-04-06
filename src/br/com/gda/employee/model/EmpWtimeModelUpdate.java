package br.com.gda.employee.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.dao.EmpWtimeStmtExecUpdate;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeExistOnDb;
import br.com.gda.employee.model.checker.CheckerEmpWtimeMandatoryWrite;
import br.com.gda.model.ModelAbstract;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpWtimeModelUpdate extends ModelAbstract<EmpWTimeInfo> {
	
	public EmpWtimeModelUpdate(String incomingData) {
		super(EmpWTimeInfo.class, incomingData);
	}
	
	
	
	@Override protected ModelCheckerAbstract<EmpWTimeInfo> buildModelCheckerHook() {
		List<ModelCheckerAbstract<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelCheckerAbstract<EmpWTimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryWrite();
		stack.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		checker = new CheckerEmpWtimeExistOnDb(EXIST_ON_DB);
		stack.add(checker);		
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	@Override protected SqlStmtExec<EmpWTimeInfo> prepareStatementExecutorHook(List<SqlStmtExecOption<EmpWTimeInfo>> sqlStmtOptions) {
		return new EmpWtimeStmtExecUpdate(sqlStmtOptions);
	}
	
	
	
	@Override protected List<EmpWTimeInfo> buildResultsetHook(List<EmpWTimeInfo> workingTimeInfos) {
		return workingTimeInfos;
	}
}
