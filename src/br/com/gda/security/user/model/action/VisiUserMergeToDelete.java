package br.com.gda.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.user.info.UserCopier;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.user.info.UserMerger;
import br.com.gda.security.user.model.decisionTree.RootUserSelect;

final class VisiUserMergeToDelete extends ActionVisitorTemplateMergeV2<UserInfo, UserInfo> {
	
	public VisiUserMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<UserInfo> recordInfos) {
		return UserCopier.copyToDelete(recordInfos);	
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> recordInfos, List<UserInfo> selectedInfos) {	
		return UserMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
