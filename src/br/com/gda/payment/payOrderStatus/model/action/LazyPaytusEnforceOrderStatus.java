package br.com.gda.payment.payOrderStatus.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderStatus.info.PaytusInfo;

public final class LazyPaytusEnforceOrderStatus extends ActionLazyTemplate<PaytusInfo, PaytusInfo> {
	
	public LazyPaytusEnforceOrderStatus(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PaytusInfo> translateRecordInfosHook(List<PaytusInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PaytusInfo> getInstanceOfActionHook(DeciTreeOption<PaytusInfo> option) {
		return new StdPaytusEnforceOrderStatus(option);
	}
	
	
	
	@Override protected DeciResult<PaytusInfo> translateResultHook(DeciResult<PaytusInfo> result) {
		return result;
	}
}
