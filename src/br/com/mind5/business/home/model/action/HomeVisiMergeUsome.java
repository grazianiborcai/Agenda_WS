package br.com.mind5.business.home.model.action;

import java.util.List;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.info.HomeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userHome.info.UsomeInfo;
import br.com.mind5.security.userHome.model.decisionTree.UsomeRootSelect;

public final class HomeVisiMergeUsome extends ActionVisitorTemplateMerge<HomeInfo, UsomeInfo> {
	
	public HomeVisiMergeUsome(DeciTreeOption<HomeInfo> option) {
		super(option, UsomeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsomeInfo>> getTreeClassHook() {
		return UsomeRootSelect.class;
	}
	
	
	
	@Override protected List<HomeInfo> mergeHook(List<HomeInfo> baseInfos, List<UsomeInfo> selectedInfos) {	
		return HomeMerger.mergeWithUsome(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
