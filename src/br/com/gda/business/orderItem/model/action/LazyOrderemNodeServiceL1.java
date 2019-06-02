package br.com.gda.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.model.decisionTree.NodeOrderemServiceL1;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyOrderemNodeServiceL1 extends ActionLazyTemplate<OrderemInfo, OrderemInfo> {
	
	public LazyOrderemNodeServiceL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderemInfo> translateRecordInfosHook(List<OrderemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrderemInfo> getInstanceOfActionHook(DeciTreeOption<OrderemInfo> option) {
		return new NodeOrderemServiceL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OrderemInfo> translateResultHook(DeciResult<OrderemInfo> result) {
		return result;
	}
}
