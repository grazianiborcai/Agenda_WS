package br.com.gda.business.storeLeaveDate.model.action;

import java.sql.Connection;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateMerger;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolevateSelectKey;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStolevateMergeToDeleteKey extends ActionVisitorTemplateMerge<StolevateInfo, StolevateInfo> {
	
	public VisiStolevateMergeToDeleteKey(Connection conn, String schemaName) {
		super(conn, schemaName, StolevateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolevateInfo>> getTreeClassHook() {
		return RootStolevateSelectKey.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<StolevateInfo>> getMergerClassHook() {
		return StolevateMerger.class;
	}
}
