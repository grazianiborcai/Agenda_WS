package br.com.gda.security.userPassword.model.action;

import java.sql.Connection;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.decisionTree.RootUserSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.info.UpswdMerger;

final class VisiUpswdMergeUser extends ActionVisitorTemplateMerge<UpswdInfo, UserInfo> {
	
	public VisiUpswdMergeUser(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<UpswdInfo>> getMergerClassHook() {
		return UpswdMerger.class;
	}
}
