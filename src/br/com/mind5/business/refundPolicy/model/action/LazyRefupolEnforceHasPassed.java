package br.com.mind5.business.refundPolicy.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyRefupolEnforceHasPassed extends ActionLazyTemplate<RefupolInfo, RefupolInfo> {
	
	public LazyRefupolEnforceHasPassed(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefupolInfo> translateRecordInfosHook(List<RefupolInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<RefupolInfo> getInstanceOfActionHook(DeciTreeOption<RefupolInfo> option) {
		return new StdRefupolEnforceHasPassed(option);
	}
	
	
	
	@Override protected DeciResult<RefupolInfo> translateResultHook(DeciResult<RefupolInfo> result) {
		return result;
	}
}
