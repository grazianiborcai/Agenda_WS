package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrderDaoInsert extends ActionLazyTemplate<OrderInfo, OrderInfo> {

	public LazyOrderDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderInfo> translateRecordInfosHook(List<OrderInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrderInfo> getInstanceOfActionHook(DeciTreeOption<OrderInfo> option) {
		return new StdOrderDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<OrderInfo> translateResultHook(DeciResult<OrderInfo> result) {
		return result;
	}
}
