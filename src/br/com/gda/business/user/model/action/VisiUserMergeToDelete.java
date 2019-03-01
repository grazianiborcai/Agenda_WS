package br.com.gda.business.user.model.action;

import java.sql.Connection;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.business.user.model.decisionTree.RootUserSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserMergeToDelete extends ActionVisitorTemplateMerge<UserInfo, UserInfo> {
	
	public VisiUserMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<UserInfo>> getMergerClassHook() {
		return UserMerger.class;
	}
}
