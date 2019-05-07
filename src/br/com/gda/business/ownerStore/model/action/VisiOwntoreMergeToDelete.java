package br.com.gda.business.ownerStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.ownerStore.info.OwntoreMerger;
import br.com.gda.business.ownerStore.model.decisionTree.RootOwntoreSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwntoreMergeToDelete extends ActionVisitorTemplateMergeV2<OwntoreInfo, OwntoreInfo> {
	
	public VisiOwntoreMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, OwntoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwntoreInfo>> getTreeClassHook() {
		return RootOwntoreSelect.class;
	}
	
	
	
	@Override protected List<OwntoreInfo> mergeHook(List<OwntoreInfo> recordInfos, List<OwntoreInfo> selectedInfos) {	
		return OwntoreMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
