package br.com.gda.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.info.OrderemMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiOrderemMergeToSelect extends ActionVisitorTemplateMergeV2<OrderemInfo, OrderemInfo> {
	
	public VisiOrderemMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrderemInfo>> getActionClassHook() {
		return StdOrderemSelect.class;
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> recordInfos, List<OrderemInfo> selectedInfos) {	
		return OrderemMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
