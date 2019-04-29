package br.com.gda.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.info.EmposMerger;
import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPositionSelect;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmposMergePosition extends ActionVisitorTemplateMerge<EmposInfo, PositionInfo> {
	
	public VisiEmposMergePosition(Connection conn, String schemaName) {
		super(conn, schemaName, PositionInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PositionInfo>> getTreeClassHook() {
		return RootPositionSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> recordInfos, List<PositionInfo> selectedInfos) {	
		return EmposMerger.mergeWithPosition(selectedInfos, recordInfos);
	}
}
