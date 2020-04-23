package br.com.mind5.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplateSelect;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmplateRootSelect extends ActionLazyTemplateV2<EmplateInfo, EmplateInfo> {
	
	public LazyEmplateRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmplateInfo> translateRecordInfosHook(List<EmplateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmplateInfo> getInstanceOfActionHook(DeciTreeOption<EmplateInfo> option) {
		return new RootEmplateSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmplateInfo> translateResultHook(DeciResult<EmplateInfo> result) {
		return result;
	}
}
