package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class LazyPaymoipCard extends ActionLazyTemplate<PaymoipInfo, PaymoipInfo> {

	public LazyPaymoipCard(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PaymoipInfo> translateRecordInfosHook(List<PaymoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PaymoipInfo> getInstanceOfActionHook(DeciTreeOption<PaymoipInfo> option) {
		return new StdPaymoipCard(option);
	}
	
	
	
	@Override protected DeciResult<PaymoipInfo> translateResultHook(DeciResult<PaymoipInfo> result) {
		return result;
	}
}
