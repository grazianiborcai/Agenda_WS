package br.com.gda.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.info.StolateMerger;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolateSelectKey;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisStolateMergeToDeleteKey extends ActionVisitorTemplateMergeV2<StolateInfo, StolateInfo> {
	
	public VisStolateMergeToDeleteKey(Connection conn, String schemaName) {
		super(conn, schemaName, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolateInfo>> getTreeClassHook() {
		return RootStolateSelectKey.class;
	}
	
	
	
	@Override protected List<StolateInfo> mergeHook(List<StolateInfo> recordInfos, List<StolateInfo> selectedInfos) {	
		return StolateMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
