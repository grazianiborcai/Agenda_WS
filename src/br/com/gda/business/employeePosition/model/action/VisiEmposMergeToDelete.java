package br.com.gda.business.employeePosition.model.action;

import java.sql.Connection;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.info.EmposMerger;
import br.com.gda.business.employeePosition.model.decisionTree.RootEmposSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmposMergeToDelete extends ActionVisitorTemplateMerge<EmposInfo, EmposInfo> {
	
	public VisiEmposMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmposInfo>> getTreeClassHook() {
		return RootEmposSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmposInfo>> getMergerClassHook() {
		return EmposMerger.class;
	}
}
