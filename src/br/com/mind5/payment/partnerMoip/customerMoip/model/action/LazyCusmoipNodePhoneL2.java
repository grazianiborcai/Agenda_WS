package br.com.mind5.payment.partnerMoip.customerMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.payment.partnerMoip.customerMoip.model.decisionTree.NodeCusmoipPhoneL2;

public final class LazyCusmoipNodePhoneL2 extends ActionLazyTemplate<CusmoipInfo, CusmoipInfo> {

	public LazyCusmoipNodePhoneL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusmoipInfo> translateRecordInfosHook(List<CusmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusmoipInfo> getInstanceOfActionHook(DeciTreeOption<CusmoipInfo> option) {
		return new NodeCusmoipPhoneL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CusmoipInfo> translateResultHook(DeciResult<CusmoipInfo> result) {
		return result;
	}
}
