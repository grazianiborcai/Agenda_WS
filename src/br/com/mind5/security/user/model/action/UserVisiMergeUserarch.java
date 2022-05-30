package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.decisionTree.UserarchRootSelect;

public final class UserVisiMergeUserarch extends ActionVisitorTemplateMerge<UserInfo, UserarchInfo> {
	
	public UserVisiMergeUserarch(DeciTreeOption<UserInfo> option) {
		super(option, UserarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserarchInfo>> getTreeClassHook() {
		return UserarchRootSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> baseInfos, List<UserarchInfo> selectedInfos) {	
		return UserMerger.mergeWithUserarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
