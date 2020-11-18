package br.com.mind5.business.employeeSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.decisionTree.RootEmparchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmparchRootSelect extends ActionLazyTemplate<EmparchInfo, EmparchInfo> {

	public LazyEmparchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmparchInfo> translateRecordInfosHook(List<EmparchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmparchInfo> getInstanceOfActionHook(DeciTreeOption<EmparchInfo> option) {
		return new RootEmparchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmparchInfo> translateResultHook(DeciResult<EmparchInfo> result) {
		return result;
	}
}
