package br.com.gda.employee.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.dao.EmpStmtOption;
import br.com.gda.employee.dao.EmpWtimeStmtExecDelete;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeExistOnDb;
import br.com.gda.employee.model.checker.CheckerEmpWtimeMandatoryWrite;
import br.com.gda.model.ModelAbstract;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.sql.SqlStmtExecutor;

public final class EmpWtimeModelDelete extends ModelAbstract<EmpWTimeInfo> {

	public EmpWtimeModelDelete(EmpWTimeInfo workingTimeInfo) {
		super(EmpWTimeInfo.class, workingTimeInfo);
	}
	
	
	
	@Override protected ModelCheckerAbstract<EmpWTimeInfo> buildModelCheckerHook() {
		List<ModelCheckerAbstract<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelCheckerAbstract<EmpWTimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryWrite();
		stack.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		checker = new CheckerEmpWtimeExistOnDb(EXIST_ON_DB);
		stack.add(checker);		
		
		 return new ModelCheckerStack<EmpWTimeInfo>(stack);
	}
	
	
	
	@Override protected SqlStmtExecutor<EmpWTimeInfo> prepareStatementExecutorHook(List<EmpStmtOption<EmpWTimeInfo>> sqlStmtOptions) {
		return new EmpWtimeStmtExecDelete(sqlStmtOptions);
	}
	
	
	
	@Override protected List<EmpWTimeInfo> buildResultsetHook(List<EmpWTimeInfo> workingTimeInfos) {
		List<EmpWTimeInfo> emptyResult = new ArrayList<>();
		emptyResult.add(new EmpWTimeInfo());
		return emptyResult;
	}
}
