package br.com.mind5.business.refundPolicyStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.decisionTree.NodeRefuporeUpsert;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyRefuporeNodeUpsert extends ActionLazyTemplate<RefuporeInfo, RefuporeInfo> {

	public LazyRefuporeNodeUpsert(Connection conn, String schemaName) {
		super(conn, schemaName); 
	}
	
	
	
	@Override protected List<RefuporeInfo> translateRecordInfosHook(List<RefuporeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<RefuporeInfo> getInstanceOfActionHook(DeciTreeOption<RefuporeInfo> option) {
		return new NodeRefuporeUpsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<RefuporeInfo> translateResultHook(DeciResult<RefuporeInfo> result) {
		return result;
	}
}
