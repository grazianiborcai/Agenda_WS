package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.NodeOrderRefugroupL1;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrderNodeRefugroupL1 extends ActionLazyTemplate<OrderInfo, OrderInfo> {
	
	public LazyOrderNodeRefugroupL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderInfo> translateRecordInfosHook(List<OrderInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrderInfo> getInstanceOfActionHook(DeciTreeOption<OrderInfo> option) {
		return new NodeOrderRefugroupL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OrderInfo> translateResultHook(DeciResult<OrderInfo> result) {
		return result;
	}
}
