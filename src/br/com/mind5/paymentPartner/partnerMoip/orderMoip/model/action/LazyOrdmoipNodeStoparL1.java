package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree.NodeOrdmoipStoparL1;

public final class LazyOrdmoipNodeStoparL1 extends ActionLazyTemplateV1<OrdmoipInfo, OrdmoipInfo> {
	
	public LazyOrdmoipNodeStoparL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdmoipInfo> translateRecordInfosHook(List<OrdmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrdmoipInfo> getInstanceOfActionHook(DeciTreeOption<OrdmoipInfo> option) {
		return new NodeOrdmoipStoparL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OrdmoipInfo> translateResultHook(DeciResult<OrdmoipInfo> result) {
		return result;
	}
}
