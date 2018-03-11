package br.com.gda.employee.model;

import br.com.gda.employee.dao.EmpWorkTimeStmtExecInsert;
import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.json.JsonToList;

public class EmpWorkTimeModelInsert extends EmpWorkTimeModelAbstract {
	
	public EmpWorkTimeModelInsert(String incomingData) {
		super(incomingData);
	}
	
	
	
	@Override protected void parseRawInfoHook() {
		JsonToList<EmpWorkTimeInfo> parser = new JsonToList<>(EmpWorkTimeInfo.class);
		workingTimeInfos = parser.parse(this.rawInfo);
	}
	
	
	
	@Override protected void prepareStatementExecutorHook() {
		this.sqlStmtExecutor = new EmpWorkTimeStmtExecInsert(this.sqlStmtOptions);
	}
}