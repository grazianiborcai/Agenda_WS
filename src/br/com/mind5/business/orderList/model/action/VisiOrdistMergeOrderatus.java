package br.com.mind5.business.orderList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.masterData.orderStatus.model.decisionTree.RootOrderatusSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOrdistMergeOrderatus extends ActionVisitorTemplateMergeV1<OrdistInfo, OrderatusInfo> {
	
	public VisiOrdistMergeOrderatus(Connection conn, String schemaName) {
		super(conn, schemaName, OrderatusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderatusInfo>> getTreeClassHook() {
		return RootOrderatusSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> baseInfos, List<OrderatusInfo> selectedInfos) {	
		return OrdistMerger.mergeWithOrderatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
