package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class LazyPayordEnforceStatusWaiting extends ActionLazyTemplate<PayordInfo, PayordInfo> {
	
	public LazyPayordEnforceStatusWaiting(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordInfo> translateRecordInfosHook(List<PayordInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayordInfo> getInstanceOfActionHook(DeciTreeOption<PayordInfo> option) {
		return new StdPayordEnforceStatusWaiting(option);
	}
	
	
	
	@Override protected DeciResult<PayordInfo> translateResultHook(DeciResult<PayordInfo> result) {
		return result;
	}
}
