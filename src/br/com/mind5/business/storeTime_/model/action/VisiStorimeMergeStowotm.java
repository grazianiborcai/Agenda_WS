package br.com.mind5.business.storeTime_.model.action;

import java.sql.Connection;

import br.com.mind5.business.storeTime_.info.StorimeInfo;
import br.com.mind5.business.storeTime_.info.StorimeMerger;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.decisionTree.RootStowotmSelect;
import br.com.mind5.info.obsolete.InfoWritterFactory_;
import br.com.mind5.model.action.obsolete.ActionVisitorTemplateMerge_;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStorimeMergeStowotm extends ActionVisitorTemplateMerge_<StorimeInfo, StowotmInfo> {
	
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
