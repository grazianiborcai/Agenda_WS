package br.com.gda.security.userPassword.model.action;

import java.sql.Connection;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.decisionTree.RootUserSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.info.UpswdMerger;

final class VisiUpswdMergeUser extends ActionVisitorTemplateMerge_<UpswdInfo, UserInfo> {
	
	public VisiUpswdMergeUser(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UpswdInfo>> getMergerClassHook() {
		return UpswdMerger.class;
	}
}
