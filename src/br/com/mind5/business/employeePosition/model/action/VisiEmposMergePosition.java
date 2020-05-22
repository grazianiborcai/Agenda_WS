package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposMerger;
import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.masterData.position.model.decisionTree.RootPositionSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmposMergePosition extends ActionVisitorTemplateMergeV1<EmposInfo, PositionInfo> {
	
	public VisiEmposMergePosition(Connection conn, String schemaName) {
		super(conn, schemaName, PositionInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PositionInfo>> getTreeClassHook() {
		return RootPositionSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> baseInfos, List<PositionInfo> selectedInfos) {	
		return EmposMerger.mergeWithPosition(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
