package br.com.gda.business.storeWorkTime.model.action;

import java.sql.Connection;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.info.StowotmMerger;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStowotmMergeToDelete extends ActionVisitorTemplateMerge<StowotmInfo, StowotmInfo> {
	
	public VisiStowotmMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotmInfo>> getTreeClassHook() {
		return RootStowotmSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StowotmInfo>> getMergerClassHook() {
		return StowotmMerger.class;
	}
}
