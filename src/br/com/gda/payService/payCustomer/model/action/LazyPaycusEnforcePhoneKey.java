package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class LazyPaycusEnforcePhoneKey extends ActionLazyTemplate<PaycusInfo, PaycusInfo> {
	
	public LazyPaycusEnforcePhoneKey(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PaycusInfo> translateRecordInfosHook(List<PaycusInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PaycusInfo> getInstanceOfActionHook(DeciTreeOption<PaycusInfo> option) {
		return new StdPaycusEnforcePhoneKey(option);
	}
	
	
	
	@Override protected DeciResult<PaycusInfo> translateResultHook(DeciResult<PaycusInfo> result) {
		return result;
	}
}
