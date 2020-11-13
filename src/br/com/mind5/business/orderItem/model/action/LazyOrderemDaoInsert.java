package br.com.mind5.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrderemDaoInsert extends ActionLazyTemplate<OrderemInfo, OrderemInfo> {
	
	public LazyOrderemDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderemInfo> translateRecordInfosHook(List<OrderemInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<OrderemInfo> getInstanceOfActionHook(DeciTreeOption<OrderemInfo> option) {
		return new StdOrderemDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<OrderemInfo> translateResultHook(DeciResult<OrderemInfo> result) {
		return result;
	}
}
