package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiOrderMergeToSelect extends ActionVisitorTemplateMergeV2<OrderInfo, OrderInfo> {
	
	public VisiOrderMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrderInfo>> getActionClassHook() {
		return StdOrderSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> recordInfos, List<OrderInfo> selectedInfos) {	
		return OrderMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
