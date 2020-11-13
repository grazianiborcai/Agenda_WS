package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree.NodeOrdmoipSysparL1;

public final class LazyOrdmoipNodeSysparL1 extends ActionLazyTemplate<OrdmoipInfo, OrdmoipInfo> {
	
	public LazyOrdmoipNodeSysparL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdmoipInfo> translateRecordInfosHook(List<OrdmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<OrdmoipInfo> getInstanceOfActionHook(DeciTreeOption<OrdmoipInfo> option) {
		return new NodeOrdmoipSysparL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OrdmoipInfo> translateResultHook(DeciResult<OrdmoipInfo> result) {
		return result;
	}
}
