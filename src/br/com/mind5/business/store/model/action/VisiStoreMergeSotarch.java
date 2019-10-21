package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.decisionTree.RootSotarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStoreMergeSotarch extends ActionVisitorTemplateMergeV2<StoreInfo, SotarchInfo> {
	
	public VisiStoreMergeSotarch(Connection conn, String schemaName) {
		super(conn, schemaName, SotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SotarchInfo>> getTreeClassHook() {
		return RootSotarchSelect.class;
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> recordInfos, List<SotarchInfo> selectedInfos) {	
		return StoreMerger.mergeWithSotarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
