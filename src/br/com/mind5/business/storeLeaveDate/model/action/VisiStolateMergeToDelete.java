package br.com.mind5.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateMerger;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.RootStolateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStolateMergeToDelete extends ActionVisitorTemplateMergeV2<StolateInfo, StolateInfo> {
	
	public VisiStolateMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolateInfo>> getTreeClassHook() {
		return RootStolateSelect.class;
	}
	
	
	
	@Override protected List<StolateInfo> mergeHook(List<StolateInfo> recordInfos, List<StolateInfo> selectedInfos) {	
		return StolateMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
