package br.com.mind5.security.userList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.info.UselisMerger;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.decisionTree.UserarchRootSelect;

public final class UselisVisiMergeUserarch extends ActionVisitorTemplateMerge<UselisInfo, UserarchInfo> {
	
	public UselisVisiMergeUserarch(DeciTreeOption<UselisInfo> option) {
		super(option, UserarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserarchInfo>> getTreeClassHook() {
		return UserarchRootSelect.class;
	}
	
	
	
	@Override protected List<UselisInfo> mergeHook(List<UselisInfo> baseInfos, List<UserarchInfo> selectedInfos) {	
		return UselisMerger.mergeWithUserarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
