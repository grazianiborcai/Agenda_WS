package br.com.mind5.payment.refundOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

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
