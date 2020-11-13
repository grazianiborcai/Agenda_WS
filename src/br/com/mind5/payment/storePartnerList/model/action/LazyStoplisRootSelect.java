package br.com.mind5.payment.storePartnerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.decisionTree.RootStoplisSelect;

public final class LazyStoplisRootSelect extends ActionLazyTemplate<StoplisInfo, StoplisInfo> {
	
	public LazyStoplisRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoplisInfo> translateRecordInfosHook(List<StoplisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoplisInfo> getInstanceOfActionHook(DeciTreeOption<StoplisInfo> option) {
		return new RootStoplisSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoplisInfo> translateResultHook(DeciResult<StoplisInfo> result) {
		return result;
	}
}
