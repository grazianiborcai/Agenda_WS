package br.com.mind5.security.username.model.action;

import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootAuthGrRoleSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.info.UsernameMerger;

final class VisiUsernameMergeAuthGrRole extends ActionVisitorTemplateMergeV2<UsernameInfo, AuthGrRoleInfo> {
	
	public VisiUsernameMergeAuthGrRole(DeciTreeOption<UsernameInfo> option) {
		super(option, AuthGrRoleInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AuthGrRoleInfo>> getTreeClassHook() {
		return RootAuthGrRoleSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> mergeHook(List<UsernameInfo> baseInfos, List<AuthGrRoleInfo> selectedInfos) {	
		return UsernameMerger.mergeWithAuthGrRole(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
