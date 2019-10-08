package br.com.gda.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateMerger;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolevateSelectKey;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStolevateMergeToDeleteKey extends ActionVisitorTemplateMergeV2<StolevateInfo, StolevateInfo> {
	
	public VisiStolevateMergeToDeleteKey(Connection conn, String schemaName) {
		super(conn, schemaName, StolevateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolevateInfo>> getTreeClassHook() {
		return RootStolevateSelectKey.class;
	}
	
	
	
	@Override protected List<StolevateInfo> mergeHook(List<StolevateInfo> recordInfos, List<StolevateInfo> selectedInfos) {	
		return StolevateMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
