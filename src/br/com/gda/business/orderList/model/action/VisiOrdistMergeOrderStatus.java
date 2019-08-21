package br.com.gda.business.orderList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.masterData.model.decisionTree.RootOrderStatusSelect;
import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.business.orderList.info.OrdistMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrdistMergeOrderStatus extends ActionVisitorTemplateMergeV2<OrdistInfo, OrderStatusInfo> {
	
	public VisiOrdistMergeOrderStatus(Connection conn, String schemaName) {
		super(conn, schemaName, OrderStatusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderStatusInfo>> getTreeClassHook() {
		return RootOrderStatusSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> recordInfos, List<OrderStatusInfo> selectedInfos) {	
		return OrdistMerger.mergeWithOrderStatus(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
