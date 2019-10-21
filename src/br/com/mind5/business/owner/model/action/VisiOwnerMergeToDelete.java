package br.com.mind5.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.business.owner.model.decisionTree.RootOwnerSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOwnerMergeToDelete extends ActionVisitorTemplateMergeV2<OwnerInfo, OwnerInfo> {
	
	public VisiOwnerMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnerInfo>> getTreeClassHook() {
		return RootOwnerSelect.class;
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> recordInfos, List<OwnerInfo> selectedInfos) {	
		return OwnerMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
