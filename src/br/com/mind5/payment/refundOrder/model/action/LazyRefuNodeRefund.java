package br.com.mind5.payment.refundOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.decisionTree.NodeRefuRefund;

public final class LazyRefuNodeRefund extends ActionLazyTemplate<RefuInfo, RefuInfo> {
	
	public LazyRefuNodeRefund(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<RefuInfo> translateRecordInfosHook(List<RefuInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<RefuInfo> getInstanceOfActionHook(DeciTreeOption<RefuInfo> option) {
		return new NodeRefuRefund(option).toAction();
	}
	
	
	
	@Override protected DeciResult<RefuInfo> translateResultHook(DeciResult<RefuInfo> result) {
		return result;
	}
}
