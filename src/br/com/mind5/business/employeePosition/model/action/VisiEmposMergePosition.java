package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposMerger;
import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootPositionSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmposMergePosition extends ActionVisitorTemplateMergeV2<EmposInfo, PositionInfo> {
	
	public VisiEmposMergePosition(Connection conn, String schemaName) {
		super(conn, schemaName, PositionInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PositionInfo>> getTreeClassHook() {
		return RootPositionSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> recordInfos, List<PositionInfo> selectedInfos) {	
		return EmposMerger.mergeWithPosition(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
