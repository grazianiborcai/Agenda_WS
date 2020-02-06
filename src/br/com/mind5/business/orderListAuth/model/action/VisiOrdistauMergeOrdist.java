package br.com.mind5.business.orderListAuth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.RootOrdistSearch;
import br.com.mind5.business.orderListAuth.info.OrdistauInfo;
import br.com.mind5.business.orderListAuth.info.OrdistauMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOrdistauMergeOrdist extends ActionVisitorTemplateMergeV2<OrdistauInfo, OrdistInfo> {
	
	public VisiOrdistauMergeOrdist(Connection conn, String schemaName) {
		super(conn, schemaName, OrdistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdistInfo>> getTreeClassHook() {
		return RootOrdistSearch.class;
	}
	
	
	
	@Override protected List<OrdistauInfo> mergeHook(List<OrdistauInfo> baseInfos, List<OrdistInfo> selectedInfos) {	
		return OrdistauMerger.mergeWithOrdist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
