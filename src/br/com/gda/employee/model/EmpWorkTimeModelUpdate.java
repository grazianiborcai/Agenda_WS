package br.com.gda.employee.model;

import java.util.List;

import br.com.gda.employee.dao.EmpWorkTimeStmtExecUpdate;
import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.json.JsonToList;

public final class EmpWorkTimeModelUpdate extends EmpWorkTimeModelAbstract {
	
	public EmpWorkTimeModelUpdate(String incomingData) {
		super(incomingData);
	}
	
	
	
	@Override protected void parseRawInfoHook() {
		JsonToList<EmpWorkTimeInfo> parser = new JsonToList<>(EmpWorkTimeInfo.class);
		workingTimeInfos = parser.parse(this.rawInfo);
	}
	
	
	
	@Override protected void prepareStatementExecutorHook() {
		this.sqlStmtExecutor = new EmpWorkTimeStmtExecUpdate(this.sqlStmtOptions);
	}
	
	
	
	@Override 	protected List<EmpWorkTimeInfo> buildResultsetHook() {
		return this.workingTimeInfos;
	}
}
