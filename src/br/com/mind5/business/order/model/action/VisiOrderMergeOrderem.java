package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.RootOrderemSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

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
