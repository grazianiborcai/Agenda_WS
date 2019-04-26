package br.com.gda.business.user.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.business.masterData.model.decisionTree.RootAuthGrRoleSelect;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserMergeAuthGrRole extends ActionVisitorTemplateMerge<UserInfo, AuthGrRoleInfo> {
	
	public VisiUserMergeAuthGrRole(Connection conn, String schemaName) {
		super(conn, schemaName, AuthGrRoleInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AuthGrRoleInfo>> getTreeClassHook() {
		return RootAuthGrRoleSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UserInfo>> getMergerClassHook() {
		return UserMerger.class;
	}
}
