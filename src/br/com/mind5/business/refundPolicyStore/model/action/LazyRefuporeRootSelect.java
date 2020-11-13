package br.com.mind5.business.refundPolicyStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.decisionTree.RootRefuporeSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyRefuporeRootSelect extends ActionLazyTemplate<RefuporeInfo, RefuporeInfo> {

	public LazyRefuporeRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName); 
	}
	
	
	
	@Override protected List<RefuporeInfo> translateRecordInfosHook(List<RefuporeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<RefuporeInfo> getInstanceOfActionHook(DeciTreeOption<RefuporeInfo> option) {
		return new RootRefuporeSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<RefuporeInfo> translateResultHook(DeciResult<RefuporeInfo> result) {
		return result;
	}
}
