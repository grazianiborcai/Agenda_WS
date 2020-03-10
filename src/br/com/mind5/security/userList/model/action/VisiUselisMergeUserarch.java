package br.com.mind5.security.userList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.info.UselisMerger;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.decisionTree.RootUserarchSelect;

final class VisiUselisMergeUserarch extends ActionVisitorTemplateMergeV2<UselisInfo, UserarchInfo> {
	
	public VisiUselisMergeUserarch(Connection conn, String schemaName) {
		super(conn, schemaName, UserarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserarchInfo>> getTreeClassHook() {
		return RootUserarchSelect.class;
	}
	
	
	
	@Override protected List<UselisInfo> mergeHook(List<UselisInfo> baseInfos, List<UserarchInfo> selectedInfos) {	
		return UselisMerger.mergeWithUserarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
