package br.com.gda.business.storeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.info.StowotmMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiStowotmMergeUsername extends ActionVisitorTemplateMerge_<StowotmInfo, UsernameInfo> {
	
	public VisiStowotmMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	protected List<UsernameInfo> toActionClassHook(List<StowotmInfo> recordInfos) {
		return UsernameCopier.copyFromStowotm(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StowotmInfo>> getMergerClassHook() {
		return StowotmMerger.class;
	}
}
