package br.com.mind5.business.orderReserve.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrderveMergeToSelect extends ActionLazyTemplate<OrderveInfo, OrderveInfo> {

	public LazyOrderveMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrderveInfo> translateRecordInfosHook(List<OrderveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrderveInfo> getInstanceOfActionHook(DeciTreeOption<OrderveInfo> option) {
		return new StdOrderveMergeToSelect(option);
	}
	
	
	
	@Override protected DeciResult<OrderveInfo> translateResultHook(DeciResult<OrderveInfo> result) {
		return result;
	}
}
