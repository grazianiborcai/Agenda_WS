package br.com.gda.payment.payOrderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderMoip.info.PayordmoipInfo;

public final class LazyPayordmoipEnforceProducts extends ActionLazyTemplate<PayordmoipInfo, PayordmoipInfo> {
	
	public LazyPayordmoipEnforceProducts(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordmoipInfo> translateRecordInfosHook(List<PayordmoipInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayordmoipInfo> getInstanceOfActionHook(DeciTreeOption<PayordmoipInfo> option) {
		return new StdPayordmoipEnforceProducts(option);
	}
	
	
	
	@Override protected DeciResult<PayordmoipInfo> translateResultHook(DeciResult<PayordmoipInfo> result) {
		return result;
	}
}
