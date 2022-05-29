package br.com.mind5.security.userHome.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userHome.info.UsomeInfo;
import br.com.mind5.security.userHome.info.UsomeMerger;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

public final class UsomeVisiMergeUsername extends ActionVisitorTemplateMerge<UsomeInfo, UsernameInfo> {
	
	public UsomeVisiMergeUsername(DeciTreeOption<UsomeInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsomeInfo> mergeHook(List<UsomeInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return UsomeMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
