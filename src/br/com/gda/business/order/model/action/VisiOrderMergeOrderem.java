package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.model.decisionTree.RootOrderemSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderMergeOrderem extends ActionVisitorTemplateMergeV2<OrderInfo, OrderemInfo> {
	
	public VisiOrderMergeOrderem(Connection conn, String schemaName) {
		super(conn, schemaName, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return RootOrderemSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> recordInfos, List<OrderemInfo> selectedInfos) {	
		return OrderMerger.mergeWithOrderem(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
