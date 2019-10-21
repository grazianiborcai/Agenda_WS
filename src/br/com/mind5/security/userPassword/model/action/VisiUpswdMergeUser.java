package br.com.mind5.security.userPassword.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserSelect;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.info.UpswdMerger;

final class VisiUpswdMergeUser extends ActionVisitorTemplateMergeV2<UpswdInfo, UserInfo> {
	
	public VisiUpswdMergeUser(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelect.class;
	}
	
	
	
	@Override protected List<UpswdInfo> mergeHook(List<UpswdInfo> recordInfos, List<UserInfo> selectedInfos) {	
		return UpswdMerger.mergeWithUser(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
