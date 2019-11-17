package br.com.mind5.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplateDelete;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmplateRootDelete extends ActionLazyTemplate<EmplateInfo, EmplateInfo> {
	
	public LazyEmplateRootDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmplateInfo> translateRecordInfosHook(List<EmplateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmplateInfo> getInstanceOfActionHook(DeciTreeOption<EmplateInfo> option) {
		return new RootEmplateDelete(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmplateInfo> translateResultHook(DeciResult<EmplateInfo> result) {
		return result;
	}
}
