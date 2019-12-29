package br.com.mind5.security.userAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserSearch;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userAuthentication.info.UauthMerger;

final class VisiUauthMergeUser extends ActionVisitorTemplateMergeV2<UauthInfo, UserInfo> {
	
	public VisiUauthMergeUser(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSearch.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<UauthInfo> recordInfos) {
		return UserCopier.copyFromUauth(recordInfos);
	}
	
	
	
	@Override protected List<UauthInfo> mergeHook(List<UauthInfo> recordInfos, List<UserInfo> selectedInfos) {	
		return UauthMerger.mergeWithUser(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
