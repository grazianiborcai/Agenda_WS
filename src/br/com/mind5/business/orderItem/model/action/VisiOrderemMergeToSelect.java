package br.com.mind5.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiOrderemMergeToSelect extends ActionVisitorTemplateMerge<OrderemInfo, OrderemInfo> {
	
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
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
