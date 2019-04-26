package br.com.gda.business.storeLeaveDate.model.action;

import java.sql.Connection;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateMerger;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolevateSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStolevateMergeToDelete extends ActionVisitorTemplateMerge<StolevateInfo, StolevateInfo> {
	
	public VisiStolevateMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, StolevateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolevateInfo>> getTreeClassHook() {
		return RootStolevateSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StolevateInfo>> getMergerClassHook() {
		return StolevateMerger.class;
	}
}
