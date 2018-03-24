package br.com.gda.employee.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.dao.EmpStmtOption;
import br.com.gda.employee.dao.EmpWtimeStmtExecInsert;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeExistOnDb;
import br.com.gda.employee.model.checker.CheckerEmpWtimeMandatoryWrite;
import br.com.gda.model.ModelAbstract;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.sql.SqlStmtExecutor;

public class EmpWtimeModelInsert extends ModelAbstract<EmpWTimeInfo> {
	
	public EmpWtimeModelInsert(String incomingData) {
		super(EmpWTimeInfo.class, incomingData);
	}
	
	
	
	@Override protected ModelCheckerAbstract<EmpWTimeInfo> buildModelCheckerHook() {
		List<ModelCheckerAbstract<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelCheckerAbstract<EmpWTimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryWrite();
		stack.add(checker);
		
		final boolean DONT_EXIST_ON_DB = false;	
		checker = new CheckerEmpWtimeExistOnDb(DONT_EXIST_ON_DB);
		stack.add(checker);		
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	@Override protected SqlStmtExecutor<EmpWTimeInfo> prepareStatementExecutorHook(List<EmpStmtOption<EmpWTimeInfo>> sqlStmtOptions) {
		return new EmpWtimeStmtExecInsert(sqlStmtOptions);
	}
	
	
	
	@Override protected List<EmpWTimeInfo> buildResultsetHook(List<EmpWTimeInfo> workingTimeInfos) {
		return workingTimeInfos;
	}
}