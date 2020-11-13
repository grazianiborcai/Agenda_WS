package br.com.mind5.payment.storePartnerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class LazyStoplisMergePaypar extends ActionLazyTemplate<StoplisInfo, StoplisInfo> {
	
	public LazyStoplisMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoplisInfo> translateRecordInfosHook(List<StoplisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<StoplisInfo> getInstanceOfActionHook(DeciTreeOption<StoplisInfo> option) {
		return new StdStoplisMergePaypar(option);
	}
	
	
	
	@Override protected DeciResult<StoplisInfo> translateResultHook(DeciResult<StoplisInfo> result) {
		return result;
	}
}
