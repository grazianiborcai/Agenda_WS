package br.com.gda.payment.storePartnerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartnerList.info.StoplisInfo;

public final class LazyStoplisMergePaypar extends ActionLazyTemplate<StoplisInfo, StoplisInfo> {
	
	public LazyStoplisMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoplisInfo> translateRecordInfosHook(List<StoplisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoplisInfo> getInstanceOfActionHook(DeciTreeOption<StoplisInfo> option) {
		return new StdStoplisMergePaypar(option);
	}
	
	
	
	@Override protected DeciResult<StoplisInfo> translateResultHook(DeciResult<StoplisInfo> result) {
		return result;
	}
}
