package br.com.gda.employee.model;

import java.util.List;

import br.com.gda.employee.dao.EmpWorkTimeStmtExecInsert;
import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.employee.model.checker.CheckerEmpWorkTimeModelInsert;
import br.com.gda.json.JsonToList;
import br.com.gda.model.checker.ModelCheckerAbstract;

public class EmpWorkTimeModelInsert extends EmpWorkTimeModelAbstract {
	
	public EmpWorkTimeModelInsert(String incomingData) {
		super(incomingData);
	}
	
	
	
	@Override protected void parseRawInfoHook() {
		JsonToList<EmpWorkTimeInfo> parser = new JsonToList<>(EmpWorkTimeInfo.class);
		workingTimeInfos = parser.parse(this.rawInfo);
	}
	
	
	
	@Override protected void checkRequestHook() {
		ModelCheckerAbstract<EmpWorkTimeInfo> checker = new CheckerEmpWorkTimeModelInsert();
		boolean result = checker.check(this.workingTimeInfos);
		result = result;
	}
	
	
	
	@Override protected void prepareStatementExecutorHook() {
		this.sqlStmtExecutor = new EmpWorkTimeStmtExecInsert(this.sqlStmtOptions);
	}
	
	
	
	@Override 	protected List<EmpWorkTimeInfo> buildResultsetHook() {
		return this.workingTimeInfos;
	}
}