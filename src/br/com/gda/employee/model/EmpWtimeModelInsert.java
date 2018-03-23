package br.com.gda.employee.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.dao.EmpStmtOption;
import br.com.gda.employee.dao.EmpWtimeStmtExecInsert;
import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeExistOnDb;
import br.com.gda.employee.model.checker.CheckerEmpWtimeMandatoryWrite;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.sql.SqlStmtExecutor;

public class EmpWtimeModelInsert extends EmpWtimeModelAbstract {
	
	public EmpWtimeModelInsert(String incomingData) {
		super(incomingData);
	}
	
	
	
	@Override protected ModelCheckerAbstract<EmpWtimeInfo> buildModelCheckerHook() {
		List<ModelCheckerAbstract<EmpWtimeInfo>> stack = new ArrayList<>();		
		ModelCheckerAbstract<EmpWtimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryWrite();
		stack.add(checker);
		
		final boolean DONT_EXIST_ON_DB = false;	
		checker = new CheckerEmpWtimeExistOnDb(DONT_EXIST_ON_DB);
		stack.add(checker);		
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	@Override protected SqlStmtExecutor<EmpWtimeInfo> prepareStatementExecutorHook(List<EmpStmtOption> sqlStmtOptions) {
		return new EmpWtimeStmtExecInsert(sqlStmtOptions);
	}
	
	
	
	@Override protected List<EmpWtimeInfo> buildResultsetHook(List<EmpWtimeInfo> workingTimeInfos) {
		return workingTimeInfos;
	}
}