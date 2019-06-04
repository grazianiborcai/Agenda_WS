package br.com.gda.business.employeeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmpnapMergePersonap extends ActionLazyTemplate<EmpnapInfo, EmpnapInfo> {
	
	public LazyEmpnapMergePersonap(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpnapInfo> translateRecordInfosHook(List<EmpnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmpnapInfo> getInstanceOfActionHook(DeciTreeOption<EmpnapInfo> option) {
		return new StdEmpnapMergePersonap(option);
	}
	
	
	
	@Override protected DeciResult<EmpnapInfo> translateResultHook(DeciResult<EmpnapInfo> result) {
		return result;
	}
}
