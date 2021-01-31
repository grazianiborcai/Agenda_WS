package br.com.mind5.business.home.model.action;

import java.util.List;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.info.HomeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiHomeMergeUsername extends ActionVisitorTemplateMerge<HomeInfo, UsernameInfo> {
	
	public VisiHomeMergeUsername(DeciTreeOption<HomeInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<HomeInfo> mergeHook(List<HomeInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return HomeMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
