package br.com.gda.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.info.EmposMerger;
import br.com.gda.business.employeePosition.model.decisionTree.RootEmposSelect;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmposMergeToDelete extends ActionVisitorTemplateMerge_<EmposInfo, EmposInfo> {
	
	public VisiEmposMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmposInfo>> getTreeClassHook() {
		return RootEmposSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> recordInfos, List<EmposInfo> selectedInfos) {	
		return EmposMerger.mergeToDelete(selectedInfos, recordInfos);
	}
}
