package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class LazyPaymoipEnforcePayment extends ActionLazyTemplateV2<PaymoipInfo, PaymoipInfo> {

	public LazyPaymoipEnforcePayment(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PaymoipInfo> translateRecordInfosHook(List<PaymoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PaymoipInfo> getInstanceOfActionHook(DeciTreeOption<PaymoipInfo> option) {
		return new StdPaymoipEnforcePayment(option);
	}
	
	
	
	@Override protected DeciResult<PaymoipInfo> translateResultHook(DeciResult<PaymoipInfo> result) {
		return result;
	}
}
