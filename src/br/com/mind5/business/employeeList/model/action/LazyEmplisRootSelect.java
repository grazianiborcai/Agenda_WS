package br.com.mind5.business.employeeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmplisRootSelect extends ActionLazyTemplateV1<EmplisInfo, EmplisInfo> {
	
	public LazyEmplisRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmplisInfo> translateRecordInfosHook(List<EmplisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmplisInfo> getInstanceOfActionHook(DeciTreeOption<EmplisInfo> option) {
		return new RootEmplisSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmplisInfo> translateResultHook(DeciResult<EmplisInfo> result) {
		return result;
	}
}
