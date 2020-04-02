package br.com.mind5.business.employeeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpnapInsert extends ActionLazyTemplate<EmpnapInfo, EmpnapInfo> {
	
	public LazyEmpnapInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpnapInfo> translateRecordInfosHook(List<EmpnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmpnapInfo> getInstanceOfActionHook(DeciTreeOption<EmpnapInfo> option) {
		return new StdEmpnapInsert(option);
	}
	
	
	
	@Override protected DeciResult<EmpnapInfo> translateResultHook(DeciResult<EmpnapInfo> result) {
		return result;
	}
}
