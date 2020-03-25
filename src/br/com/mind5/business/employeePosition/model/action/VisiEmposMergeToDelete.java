package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposMerger;
import br.com.mind5.business.employeePosition.model.decisionTree.RootEmposSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmposMergeToDelete extends ActionVisitorTemplateMergeV2<EmposInfo, EmposInfo> {
	
	public VisiEmposMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmposInfo>> getTreeClassHook() {
		return RootEmposSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> baseInfos, List<EmposInfo> selectedInfos) {	
		return EmposMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}	
}
