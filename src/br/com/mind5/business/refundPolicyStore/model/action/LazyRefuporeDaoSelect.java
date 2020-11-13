package br.com.mind5.business.refundPolicyStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyRefuporeDaoSelect extends ActionLazyTemplate<RefuporeInfo, RefuporeInfo> {

	public LazyRefuporeDaoSelect(Connection conn, String schemaName) {
		super(conn, schemaName); 
	}
	
	
	
	@Override protected List<RefuporeInfo> translateRecordInfosHook(List<RefuporeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<RefuporeInfo> getInstanceOfActionHook(DeciTreeOption<RefuporeInfo> option) {
		return new StdRefuporeDaoSelect(option);
	}
	
	
	
	@Override protected DeciResult<RefuporeInfo> translateResultHook(DeciResult<RefuporeInfo> result) {
		return result;
	}
}
