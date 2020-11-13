package br.com.mind5.business.refundPolicy.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.model.decisionTree.NodeRefupolEvaluateL5;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyRefupolNodeEvaluateL5 extends ActionLazyTemplate<RefupolInfo, RefupolInfo> {
	
	public LazyRefupolNodeEvaluateL5(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefupolInfo> translateRecordInfosHook(List<RefupolInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<RefupolInfo> getInstanceOfActionHook(DeciTreeOption<RefupolInfo> option) {
		return new NodeRefupolEvaluateL5(option).toAction();
	}
	
	
	
	@Override protected DeciResult<RefupolInfo> translateResultHook(DeciResult<RefupolInfo> result) {
		return result;
	}
}
