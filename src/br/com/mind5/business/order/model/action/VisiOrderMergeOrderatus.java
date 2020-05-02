package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.masterData.orderStatus.model.decisionTree.RootOrderatusSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOrderMergeOrderatus extends ActionVisitorTemplateMergeV1<OrderInfo, OrderatusInfo> {
	
	public VisiOrderMergeOrderatus(Connection conn, String schemaName) {
		super(conn, schemaName, OrderatusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderatusInfo>> getTreeClassHook() {
		return RootOrderatusSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<OrderatusInfo> selectedInfos) {	
		return OrderMerger.mergeWithOrderatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
