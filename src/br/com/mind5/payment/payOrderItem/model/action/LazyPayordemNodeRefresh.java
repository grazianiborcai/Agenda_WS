package br.com.mind5.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.decisionTree.NodePayordemRefresh;

public final class LazyPayordemNodeRefresh extends ActionLazyTemplate<PayordemInfo, PayordemInfo> {
	
	public LazyPayordemNodeRefresh(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PayordemInfo> translateRecordInfosHook(List<PayordemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PayordemInfo> getInstanceOfActionHook(DeciTreeOption<PayordemInfo> option) {
		return new NodePayordemRefresh(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PayordemInfo> translateResultHook(DeciResult<PayordemInfo> result) {
		return result;
	}
}
