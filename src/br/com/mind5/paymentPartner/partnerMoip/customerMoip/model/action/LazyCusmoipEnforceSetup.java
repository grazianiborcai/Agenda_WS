package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class LazyCusmoipEnforceSetup extends ActionLazyTemplate<CusmoipInfo, CusmoipInfo> {

	public LazyCusmoipEnforceSetup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusmoipInfo> translateRecordInfosHook(List<CusmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CusmoipInfo> getInstanceOfActionHook(DeciTreeOption<CusmoipInfo> option) {
		return new StdCusmoipEnforceSetup(option);
	}
	
	
	
	@Override protected DeciResult<CusmoipInfo> translateResultHook(DeciResult<CusmoipInfo> result) {
		return result;
	}
}
