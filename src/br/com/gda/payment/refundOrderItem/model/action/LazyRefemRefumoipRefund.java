package br.com.gda.payment.refundOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;

public final class LazyRefemRefumoipRefund extends ActionLazyTemplate<RefemInfo, RefemInfo> {
	
	public LazyRefemRefumoipRefund(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefemInfo> translateRecordInfosHook(List<RefemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<RefemInfo> getInstanceOfActionHook(DeciTreeOption<RefemInfo> option) {
		return new StdRefemRefumoipRefund(option);
	}
	
	
	
	@Override protected DeciResult<RefemInfo> translateResultHook(DeciResult<RefemInfo> result) {
		return result;
	}
}
