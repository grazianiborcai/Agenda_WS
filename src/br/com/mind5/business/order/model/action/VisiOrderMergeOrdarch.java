package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.decisionTree.RootOrdarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOrderMergeOrdarch extends ActionVisitorTemplateMerge<OrderInfo, OrdarchInfo> {
	
	public VisiOrderMergeOrdarch(Connection conn, String schemaName) {
		super(conn, schemaName, OrdarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdarchInfo>> getTreeClassHook() {
		return RootOrdarchSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<OrdarchInfo> selectedInfos) {	
		return OrderMerger.mergeWithOrdarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
