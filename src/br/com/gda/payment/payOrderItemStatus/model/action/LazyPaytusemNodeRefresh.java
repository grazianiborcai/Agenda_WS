package br.com.gda.payment.payOrderItemStatus.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderItemStatus.info.PaytusemInfo;
import br.com.gda.payment.payOrderItemStatus.model.decisionTree.NodePaytusemRefresh;

public final class LazyPaytusemNodeRefresh extends ActionLazyTemplate<PaytusemInfo, PaytusemInfo> {
	
	public LazyPaytusemNodeRefresh(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PaytusemInfo> translateRecordInfosHook(List<PaytusemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PaytusemInfo> getInstanceOfActionHook(DeciTreeOption<PaytusemInfo> option) {
		return new NodePaytusemRefresh(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PaytusemInfo> translateResultHook(DeciResult<PaytusemInfo> result) {
		return result;
	}
}
