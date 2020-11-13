package br.com.mind5.business.employeeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmplisMergeEmparch extends ActionLazyTemplate<EmplisInfo, EmplisInfo> {
	
	public LazyEmplisMergeEmparch(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmplisInfo> translateRecordInfosHook(List<EmplisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmplisInfo> getInstanceOfActionHook(DeciTreeOption<EmplisInfo> option) {
		return new StdEmplisMergeEmparch(option);
	}
	
	
	
	@Override protected DeciResult<EmplisInfo> translateResultHook(DeciResult<EmplisInfo> result) {
		return result;
	}
}
