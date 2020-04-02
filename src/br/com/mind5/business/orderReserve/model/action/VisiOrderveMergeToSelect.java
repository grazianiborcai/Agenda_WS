package br.com.mind5.business.orderReserve.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.info.OrderveMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiOrderveMergeToSelect extends ActionVisitorTemplateMerge<OrderveInfo, OrderveInfo> {
	
	public VisiOrderveMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrderveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<OrderveInfo>> getActionClassHook() {
		return StdOrderveSelect.class;
	}
	
	
	
	@Override protected List<OrderveInfo> mergeHook(List<OrderveInfo> recordInfos, List<OrderveInfo> selectedInfos) {	
		return OrderveMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
