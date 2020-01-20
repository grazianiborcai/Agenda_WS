package br.com.mind5.business.orderList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.decisionTree.RootOrdarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOrdistMergeOrdarch extends ActionVisitorTemplateMergeV2<OrdistInfo, OrdarchInfo> {
	
	public VisiOrdistMergeOrdarch(Connection conn, String schemaName) {
		super(conn, schemaName, OrdarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdarchInfo>> getTreeClassHook() {
		return RootOrdarchSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> recordInfos, List<OrdarchInfo> selectedInfos) {	
		return OrdistMerger.mergeWithOrdarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
