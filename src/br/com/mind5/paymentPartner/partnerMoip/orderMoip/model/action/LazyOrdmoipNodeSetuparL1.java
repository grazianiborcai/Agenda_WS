package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree.NodeOrdmoipSetuparL1;

public final class LazyOrdmoipNodeSetuparL1 extends ActionLazyTemplate<OrdmoipInfo, OrdmoipInfo> {
	
	public LazyOrdmoipNodeSetuparL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdmoipInfo> translateRecordInfosHook(List<OrdmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdmoipInfo> getInstanceOfActionHook(DeciTreeOption<OrdmoipInfo> option) {
		return new NodeOrdmoipSetuparL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OrdmoipInfo> translateResultHook(DeciResult<OrdmoipInfo> result) {
		return result;
	}
}
