package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.business.masterData.model.decisionTree.RootAuthGrRoleSelect;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserMergeAuthGrRole extends ActionVisitorTemplateMergeV2<UserInfo, AuthGrRoleInfo> {
	
	public VisiUserMergeAuthGrRole(Connection conn, String schemaName) {
		super(conn, schemaName, AuthGrRoleInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AuthGrRoleInfo>> getTreeClassHook() {
		return RootAuthGrRoleSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> recordInfos, List<AuthGrRoleInfo> selectedInfos) {	
		return UserMerger.mergeWithAuthGrRole(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
