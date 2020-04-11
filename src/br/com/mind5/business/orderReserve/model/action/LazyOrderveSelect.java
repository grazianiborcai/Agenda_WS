package br.com.mind5.business.orderReserve.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrderveSelect extends ActionLazyTemplateV1<OrderveInfo, OrderveInfo> {

	public LazyOrderveSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderveInfo> translateRecordInfosHook(List<OrderveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrderveInfo> getInstanceOfActionHook(DeciTreeOption<OrderveInfo> option) {
		return new StdOrderveSelect(option);
	}
	
	
	
	@Override protected DeciResult<OrderveInfo> translateResultHook(DeciResult<OrderveInfo> result) {
		return result;
	}
}
