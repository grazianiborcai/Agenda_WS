package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.masterData.authorizationGroupRole.model.decisionTree.RootAuthgroleSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

final class VisiUserMergeAuthgrole extends ActionVisitorTemplateMergeV1<UserInfo, AuthgroleInfo> {
	
	public VisiUserMergeAuthgrole(Connection conn, String schemaName) {
		super(conn, schemaName, AuthgroleInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AuthgroleInfo>> getTreeClassHook() {
		return RootAuthgroleSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> baseInfos, List<AuthgroleInfo> selectedInfos) {	
		return UserMerger.mergeWithAuthgrole(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
