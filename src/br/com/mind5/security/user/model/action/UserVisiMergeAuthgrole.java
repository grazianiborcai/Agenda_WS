package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.masterData.authorizationGroupRole.model.decisionTree.AuthgroleRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

public final class UserVisiMergeAuthgrole extends ActionVisitorTemplateMerge<UserInfo, AuthgroleInfo> {
	
	public UserVisiMergeAuthgrole(DeciTreeOption<UserInfo> option) {
		super(option, AuthgroleInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<AuthgroleInfo>> getTreeClassHook() {
		return AuthgroleRootSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> baseInfos, List<AuthgroleInfo> selectedInfos) {	
		return UserMerger.mergeWithAuthgrole(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
