package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderCopier;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiOrderMergeToUpdate extends ActionVisitorTemplateMergeV2<OrderInfo, OrderInfo> {
	
	public VisiOrderMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrderInfo>> getActionClassHook() {
		return StdOrderSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> toActionClassHook(List<OrderInfo> recordInfos) {
		return OrderCopier.copyToSelect(recordInfos);	
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> recordInfos, List<OrderInfo> selectedInfos) {	
		return OrderMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
