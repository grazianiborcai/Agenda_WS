package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootAuthGrRoleSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

final class VisiUserMergeAuthGrRole extends ActionVisitorTemplateMergeV2<UserInfo, AuthGrRoleInfo> {
	
	public VisiUserMergeAuthGrRole(Connection conn, String schemaName) {
		super(conn, schemaName, AuthGrRoleInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AuthGrRoleInfo>> getTreeClassHook() {
		return RootAuthGrRoleSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> baseInfos, List<AuthGrRoleInfo> selectedInfos) {	
		return UserMerger.mergeWithAuthGrRole(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
