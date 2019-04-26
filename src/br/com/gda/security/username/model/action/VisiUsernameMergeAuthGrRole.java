package br.com.gda.security.username.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.business.masterData.model.decisionTree.RootAuthGrRoleSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.info.UsernameMerger;

final class VisiUsernameMergeAuthGrRole extends ActionVisitorTemplateMerge<UsernameInfo, AuthGrRoleInfo> {
	
	public VisiUsernameMergeAuthGrRole(Connection conn, String schemaName) {
		super(conn, schemaName, AuthGrRoleInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AuthGrRoleInfo>> getTreeClassHook() {
		return RootAuthGrRoleSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UsernameInfo>> getMergerClassHook() {
		return UsernameMerger.class;
	}
}
