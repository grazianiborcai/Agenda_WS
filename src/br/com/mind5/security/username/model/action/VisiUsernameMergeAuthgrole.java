package br.com.mind5.security.username.model.action;

import java.util.List;

import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.masterData.authorizationGroupRole.model.decisionTree.RootAuthgroleSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.info.UsernameMerger;

final class VisiUsernameMergeAuthgrole extends ActionVisitorTemplateMerge<UsernameInfo, AuthgroleInfo> {
	
	public VisiUsernameMergeAuthgrole(DeciTreeOption<UsernameInfo> option) {
		super(option, AuthgroleInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AuthgroleInfo>> getTreeClassHook() {
		return RootAuthgroleSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> mergeHook(List<UsernameInfo> baseInfos, List<AuthgroleInfo> selectedInfos) {	
		return UsernameMerger.mergeWithAuthgrole(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
