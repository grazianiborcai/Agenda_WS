package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootOrderStatusSelect;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOrderMergeOrderStatus extends ActionVisitorTemplateMergeV2<OrderInfo, OrderStatusInfo> {
	
	public VisiOrderMergeOrderStatus(Connection conn, String schemaName) {
		super(conn, schemaName, OrderStatusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderStatusInfo>> getTreeClassHook() {
		return RootOrderStatusSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> recordInfos, List<OrderStatusInfo> selectedInfos) {	
		return OrderMerger.mergeWithOrderStatus(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
