package br.com.gda.business.storeTime.model.action;

import java.sql.Connection;
import br.com.gda.business.storeTime.info.StorimeInfo;
import br.com.gda.business.storeTime.info.StorimeMerger;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStorimeMergeStowotm extends ActionVisitorTemplateMerge<StorimeInfo, StowotmInfo> {
	
	public VisiStorimeMergeStowotm(Connection conn, String schemaName) {
		super(conn, schemaName, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotmInfo>> getTreeClassHook() {
		return RootStowotmSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<StorimeInfo>> getMergerClassHook() {
		return StorimeMerger.class;
	}
}
