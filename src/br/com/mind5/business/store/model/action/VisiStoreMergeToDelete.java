package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.business.store.model.decisionTree.RootStoreSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStoreMergeToDelete extends ActionVisitorTemplateMergeV2<StoreInfo, StoreInfo> {
	
	public VisiStoreMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoreInfo>> getTreeClassHook() {
		return RootStoreSelect.class;
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> recordInfos, List<StoreInfo> selectedInfos) {	
		return StoreMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
