package br.com.gda.business.employeeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmplisMergePerson extends ActionLazyTemplate<EmplisInfo, EmplisInfo> {
	
	public LazyEmplisMergePerson(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmplisInfo> translateRecordInfosHook(List<EmplisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmplisInfo> getInstanceOfActionHook(DeciTreeOption<EmplisInfo> option) {
		return new StdEmplisMergePerson(option);
	}
	
	
	
	@Override protected DeciResult<EmplisInfo> translateResultHook(DeciResult<EmplisInfo> result) {
		return result;
	}
}
