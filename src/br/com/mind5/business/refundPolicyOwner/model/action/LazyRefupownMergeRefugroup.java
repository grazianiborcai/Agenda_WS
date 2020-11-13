package br.com.mind5.business.refundPolicyOwner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyRefupownMergeRefugroup extends ActionLazyTemplate<RefupownInfo, RefupownInfo> {

	public LazyRefupownMergeRefugroup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefupownInfo> translateRecordInfosHook(List<RefupownInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<RefupownInfo> getInstanceOfActionHook(DeciTreeOption<RefupownInfo> option) {
		return new StdRefupownMergeRefugroup(option);
	}
	
	
	
	@Override protected DeciResult<RefupownInfo> translateResultHook(DeciResult<RefupownInfo> result) {
		return result;
	}
}
