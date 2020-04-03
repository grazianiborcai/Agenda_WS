package br.com.mind5.security.userAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userAuthentication.info.UauthMerger;
import br.com.mind5.security.userList.info.UselisCopier;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.RootUselisSearch;

final class VisiUauthMergeUselis extends ActionVisitorTemplateMergeV1<UauthInfo, UselisInfo> {
	
	public VisiUauthMergeUselis(Connection conn, String schemaName) {
		super(conn, schemaName, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return RootUselisSearch.class;
	}
	
	
	
	@Override protected List<UselisInfo> toActionClassHook(List<UauthInfo> recordInfos) {
		return UselisCopier.copyFromUauth(recordInfos);
	}
	
	
	
	@Override protected List<UauthInfo> mergeHook(List<UauthInfo> recordInfos, List<UselisInfo> selectedInfos) {	
		return UauthMerger.mergeWithUselis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
