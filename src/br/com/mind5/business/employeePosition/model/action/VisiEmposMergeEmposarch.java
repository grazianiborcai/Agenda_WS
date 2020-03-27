package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposMerger;
import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.decisionTree.RootEmposarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmposMergeEmposarch extends ActionVisitorTemplateMerge<EmposInfo, EmposarchInfo> {
	
	public VisiEmposMergeEmposarch(Connection conn, String schemaName) {
		super(conn, schemaName, EmposarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmposarchInfo>> getTreeClassHook() {
		return RootEmposarchSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> baseInfos, List<EmposarchInfo> selectedInfos) {	
		return EmposMerger.mergeWithEmposarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
