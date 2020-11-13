package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class LazyOrdmoipEnforceCustomer extends ActionLazyTemplate<OrdmoipInfo, OrdmoipInfo> {
	
	public LazyOrdmoipEnforceCustomer(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdmoipInfo> translateRecordInfosHook(List<OrdmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdmoipInfo> getInstanceOfActionHook(DeciTreeOption<OrdmoipInfo> option) {
		return new StdOrdmoipEnforceCustomer(option);
	}
	
	
	
	@Override protected DeciResult<OrdmoipInfo> translateResultHook(DeciResult<OrdmoipInfo> result) {
		return result;
	}
}
