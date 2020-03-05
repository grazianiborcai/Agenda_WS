package br.com.mind5.payment.statusPayOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.NodePaytusUserL2;

public final class LazyPaytusNodeUserL2 extends ActionLazyTemplate<PaytusInfo, PaytusInfo> {
	
	public LazyPaytusNodeUserL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PaytusInfo> translateRecordInfosHook(List<PaytusInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PaytusInfo> getInstanceOfActionHook(DeciTreeOption<PaytusInfo> option) {
		return new NodePaytusUserL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PaytusInfo> translateResultHook(DeciResult<PaytusInfo> result) {
		return result;
	}
}