package br.com.gda.employee.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.gda.employee.dao.EmpWtimeStmtExecDelete;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWtimeExistOnDb;
import br.com.gda.employee.model.checker.CheckerEmpWtimeMandatoryWrite;
import br.com.gda.model.Model;
import br.com.gda.model.ModelHelper;
import br.com.gda.model.ModelOption;
import br.com.gda.model.ModelStmtExec;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpWtimeModelDelete implements Model {
	private ModelHelper<EmpWTimeInfo> helper;
	
	public EmpWtimeModelDelete(EmpWTimeInfo workingTimeInfo) {
		ModelOption<EmpWTimeInfo> helperOption = new ModelOption<>();
		
		helperOption.infoRecordClass = EmpWTimeInfo.class;
		helperOption.visitorChecker = buildModelChecker();
		helperOption.visitorStmtExec = buildStmtExec();
		
		helper = new ModelHelper<>(helperOption, workingTimeInfo);
	}
	
	
	
	private ModelCheckerAbstract<EmpWTimeInfo> buildModelChecker() {
		List<ModelCheckerAbstract<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelCheckerAbstract<EmpWTimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryWrite();
		stack.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		checker = new CheckerEmpWtimeExistOnDb(EXIST_ON_DB);
		stack.add(checker);		
		
		 return new ModelCheckerStack<EmpWTimeInfo>(stack);
	}
	
	
	
	private ModelStmtExec<EmpWTimeInfo> buildStmtExec() {
		return new EmpWtimeModelDeleteStmtExec();
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	private class EmpWtimeModelDeleteStmtExec implements ModelStmtExec<EmpWTimeInfo> {		
		@Override public SqlStmtExec<EmpWTimeInfo> getStmtExec(List<SqlStmtExecOption<EmpWTimeInfo>> sqlStmtOptions) {
			return new EmpWtimeStmtExecDelete(sqlStmtOptions);
		}		
	}
	
	
	/*
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
	
	
	
	@Override protected SqlStmtExec<EmpWTimeInfo> prepareStatementExecutorHook(List<SqlStmtExecOption<EmpWTimeInfo>> sqlStmtOptions) {
		return new EmpWtimeStmtExecDelete(sqlStmtOptions);
	}
	
	
	
	@Override protected List<EmpWTimeInfo> buildResultsetHook(List<EmpWTimeInfo> workingTimeInfos) {
		List<EmpWTimeInfo> emptyResult = new ArrayList<>();
		emptyResult.add(new EmpWTimeInfo());
		return emptyResult;
	}
	*/
}
