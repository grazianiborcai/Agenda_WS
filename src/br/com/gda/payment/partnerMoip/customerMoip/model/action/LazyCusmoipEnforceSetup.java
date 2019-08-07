package br.com.gda.payment.partnerMoip.customerMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class LazyCusmoipEnforceSetup extends ActionLazyTemplate<CusmoipInfo, CusmoipInfo> {

	public LazyCusmoipEnforceSetup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CusmoipInfo> translateRecordInfosHook(List<CusmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CusmoipInfo> getInstanceOfActionHook(DeciTreeOption<CusmoipInfo> option) {
		return new StdCusmoipEnforceSetup(option);
	}
	
	
	
	@Override protected DeciResult<CusmoipInfo> translateResultHook(DeciResult<CusmoipInfo> result) {
		return result;
	}
}
