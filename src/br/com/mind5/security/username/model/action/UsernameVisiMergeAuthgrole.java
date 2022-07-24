package br.com.mind5.security.username.model.action;

import java.util.List;

import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.masterData.authorizationGroupRole.model.decisionTree.AuthgroleRootSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.info.UsernameMerger;

public final class UsernameVisiMergeAuthgrole extends ActionVisitorTemplateMerge<UsernameInfo, AuthgroleInfo> {
	
	public UsernameVisiMergeAuthgrole(DeciTreeOption<UsernameInfo> option) {
		super(option, AuthgroleInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AuthgroleInfo>> getTreeClassHook() {
		return AuthgroleRootSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> mergeHook(List<UsernameInfo> baseInfos, List<AuthgroleInfo> selectedInfos) {	
		return UsernameMerger.mergeWithAuthgrole(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
