package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class LazyPayCusEnforcePhoneKey extends ActionLazyTemplate<PayCusInfo, PayCusInfo> {
	
	public LazyPayCusEnforcePhoneKey(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayCusInfo> translateRecordInfosHook(List<PayCusInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayCusInfo> getInstanceOfActionHook(DeciTreeOption<PayCusInfo> option) {
		return new StdPayCusEnforcePhoneKey(option);
	}
	
	
	
	@Override protected DeciResult<PayCusInfo> translateResultHook(DeciResult<PayCusInfo> result) {
		return result;
	}
}
