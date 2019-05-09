package br.com.gda.security.username.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.business.masterData.model.decisionTree.RootAuthGrRoleSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.info.UsernameMerger;

final class VisiUsernameMergeAuthGrRole extends ActionVisitorTemplateMergeV2<UsernameInfo, AuthGrRoleInfo> {
	
	public VisiUsernameMergeAuthGrRole(Connection conn, String schemaName) {
		super(conn, schemaName, AuthGrRoleInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AuthGrRoleInfo>> getTreeClassHook() {
		return RootAuthGrRoleSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> mergeHook(List<UsernameInfo> recordInfos, List<AuthGrRoleInfo> selectedInfos) {	
		return UsernameMerger.mergeWithAuthGrRole(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
