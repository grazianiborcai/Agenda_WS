package br.com.gda.business.orderReserve.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.orderReserve.info.OrderveInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyOrderveSelect extends ActionLazyTemplate<OrderveInfo, OrderveInfo> {

	public LazyOrderveSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderveInfo> translateRecordInfosHook(List<OrderveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrderveInfo> getInstanceOfActionHook(DeciTreeOption<OrderveInfo> option) {
		return new StdOrderveSelect(option);
	}
	
	
	
	@Override protected DeciResult<OrderveInfo> translateResultHook(DeciResult<OrderveInfo> result) {
		return result;
	}
}
