package br.com.mind5.payment.storePartnerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.decisionTree.RootStoplisSelect;

public final class LazyStoplisRootSelect extends ActionLazyTemplateV2<StoplisInfo, StoplisInfo> {
	
	public LazyStoplisRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoplisInfo> translateRecordInfosHook(List<StoplisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StoplisInfo> getInstanceOfActionHook(DeciTreeOption<StoplisInfo> option) {
		return new RootStoplisSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoplisInfo> translateResultHook(DeciResult<StoplisInfo> result) {
		return result;
	}
}
