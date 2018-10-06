package br.com.gda.business.order.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerOrderMergeEmp extends DeciActionHandlerTemplate<OrderInfo, OrderInfo> {
	
	public HandlerOrderMergeEmp(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderInfo> translateRecordInfosHook(List<OrderInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected DeciAction<OrderInfo> getInstanceOfActionHook(DeciTreeOption<OrderInfo> option) {
		return new ActionOrderMergeEmp(option);
	}
	
	
	
	@Override protected DeciResult<OrderInfo> translateResultHook(DeciResult<OrderInfo> result) {		
		return result;
	}
}
