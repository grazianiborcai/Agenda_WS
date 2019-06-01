package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.decisionTree.RootCartemSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderMergeCartem extends ActionVisitorTemplateMergeV2<OrderInfo, CartemInfo> {
	
	public VisiOrderMergeCartem(Connection conn, String schemaName) {
		super(conn, schemaName, CartemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemInfo>> getTreeClassHook() {
		return RootCartemSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> recordInfos, List<CartemInfo> selectedInfos) {	
		return OrderMerger.mergeWithCartem(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
