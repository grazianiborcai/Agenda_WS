package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.business.storeSearch.info.SotarchInfo;
import br.com.gda.business.storeSearch.model.decisionTree.RootSotarchSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

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
