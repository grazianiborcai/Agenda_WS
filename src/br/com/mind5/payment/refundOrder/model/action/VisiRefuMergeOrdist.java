package br.com.mind5.payment.refundOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.RootOrdistSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.info.RefuMerger;

final class VisiRefuMergeOrdist extends ActionVisitorTemplateMerge<RefuInfo, OrdistInfo> {
	
	public VisiRefuMergeOrdist(Connection conn, String schemaName) {
		super(conn, schemaName, OrdistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdistInfo>> getTreeClassHook() {
		return RootOrdistSelect.class;
	}
	
	
	
	@Override protected List<RefuInfo> mergeHook(List<RefuInfo> baseInfos, List<OrdistInfo> selectedInfos) {	
		return RefuMerger.mergeWithOrdist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
