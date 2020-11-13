package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.decisionTree.NodeEmposEmposarch;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmposNodeEmposarch extends ActionLazyTemplate<EmposInfo, EmposInfo> {
	
	public LazyEmposNodeEmposarch(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmposInfo> translateRecordInfosHook(List<EmposInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<EmposInfo> getInstanceOfActionHook(DeciTreeOption<EmposInfo> option) {
		return new NodeEmposEmposarch(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmposInfo> translateResultHook(DeciResult<EmposInfo> result) {
		return result;
	}
}
