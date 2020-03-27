package br.com.mind5.business.orderList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootOrderStatusSelect;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOrdistMergeOrderStatus extends ActionVisitorTemplateMerge<OrdistInfo, OrderStatusInfo> {
	
	public VisiOrdistMergeOrderStatus(Connection conn, String schemaName) {
		super(conn, schemaName, OrderStatusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderStatusInfo>> getTreeClassHook() {
		return RootOrderStatusSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> baseInfos, List<OrderStatusInfo> selectedInfos) {	
		return OrdistMerger.mergeWithOrderStatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}
