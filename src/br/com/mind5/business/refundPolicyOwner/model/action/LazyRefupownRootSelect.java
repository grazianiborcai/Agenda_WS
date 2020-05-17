package br.com.mind5.business.refundPolicyOwner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.decisionTree.RootRefupownSelectFallback;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyRefupownRootSelect extends ActionLazyTemplateV2<RefupownInfo, RefupownInfo> {

	public LazyRefupownRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefupownInfo> translateRecordInfosHook(List<RefupownInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<RefupownInfo> getInstanceOfActionHook(DeciTreeOption<RefupownInfo> option) {
		return new RootRefupownSelectFallback(option).toAction();
	}
	
	
	
	@Override protected DeciResult<RefupownInfo> translateResultHook(DeciResult<RefupownInfo> result) {
		return result;
	}
}
