package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree.NodeOrdmoipSetuparL2;

public final class LazyOrdmoipNodeSetuparL2 extends ActionLazyTemplate<OrdmoipInfo, OrdmoipInfo> {
	
	public LazyOrdmoipNodeSetuparL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdmoipInfo> translateRecordInfosHook(List<OrdmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrdmoipInfo> getInstanceOfActionHook(DeciTreeOption<OrdmoipInfo> option) {
		return new NodeOrdmoipSetuparL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OrdmoipInfo> translateResultHook(DeciResult<OrdmoipInfo> result) {
		return result;
	}
}
