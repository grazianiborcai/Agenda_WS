package br.com.gda.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.orderItem.info.OrderInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyOrderMergeCartSnap extends ActionLazyTemplate<OrderInfo, OrderInfo> {
	
	public LazyOrderMergeCartSnap(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderInfo> translateRecordInfosHook(List<OrderInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrderInfo> getInstanceOfActionHook(DeciTreeOption<OrderInfo> option) {
		return new StdOrderMergeCartSnap(option);
	}
	
	
	
	@Override protected DeciResult<OrderInfo> translateResultHook(DeciResult<OrderInfo> result) {		
		return result;
	}
}
