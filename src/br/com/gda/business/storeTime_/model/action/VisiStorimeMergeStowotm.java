package br.com.gda.business.storeTime_.model.action;

import java.sql.Connection;

import br.com.gda.business.storeTime_.info.StorimeInfo;
import br.com.gda.business.storeTime_.info.StorimeMerger;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStorimeMergeStowotm extends ActionVisitorTemplateMerge<StorimeInfo, StowotmInfo> {
	
	public VisiStorimeMergeStowotm(Connection conn, String schemaName) {
		super(conn, schemaName, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotmInfo>> getTreeClassHook() {
		return RootStowotmSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StorimeInfo>> getMergerClassHook() {
		return StorimeMerger.class;
	}
}
