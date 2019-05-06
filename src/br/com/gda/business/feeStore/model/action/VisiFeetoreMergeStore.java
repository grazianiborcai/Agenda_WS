package br.com.gda.business.feeStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.feeStore.info.FeetoreMerger;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.RootStoreSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiFeetoreMergeStore extends ActionVisitorTemplateMergeV2<FeetoreInfo, StoreInfo> {

	public VisiFeetoreMergeStore(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoreInfo>> getTreeClassHook() {
		return RootStoreSelect.class;
	}
	
	
	
	@Override protected List<FeetoreInfo> mergeHook(List<FeetoreInfo> recordInfos, List<StoreInfo> selectedInfos) {	
		return FeetoreMerger.mergeWithStore(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
