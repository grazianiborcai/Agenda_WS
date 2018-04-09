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
import br.com.gda.model.checker.ModelChecker;
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
	
	
	
	private ModelChecker<EmpWTimeInfo> buildModelChecker() {
		List<ModelChecker<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpWTimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryWrite();
		stack.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		checker = new CheckerEmpWtimeExistOnDb(EXIST_ON_DB);
		stack.add(checker);		
		
		 return new ModelCheckerStack<EmpWTimeInfo>(stack);
	}
	
	
	
	private ModelStmtExec<EmpWTimeInfo> buildStmtExec() {
		return new EmpWtimeModelStmtExec();
	}
	
	
	
	@Override public boolean executeRequest() {
		return helper.executeRequest();
	}


	
	@Override public Response getResponse() {
		return helper.getResponse();
	}
	
	
	
	private class EmpWtimeModelStmtExec implements ModelStmtExec<EmpWTimeInfo> {		
		@Override public SqlStmtExec<EmpWTimeInfo> getStmtExec(List<SqlStmtExecOption<EmpWTimeInfo>> sqlStmtOptions) {
			return new EmpWtimeStmtExecDelete(sqlStmtOptions);
		}		
	}
}
