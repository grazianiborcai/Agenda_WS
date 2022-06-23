package br.com.mind5.business.home.model.action;

import java.util.List;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.info.HomeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.model.decisionTree.StorashRootSelectNow;

public final class HomeVisiMergeStorash extends ActionVisitorTemplateMerge<HomeInfo, StorashInfo> {
	
	public HomeVisiMergeStorash(DeciTreeOption<HomeInfo> option) {
		super(option, StorashInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorashInfo>> getTreeClassHook() {
		return StorashRootSelectNow.class;
	}
	
	
	
	@Override protected List<HomeInfo> mergeHook(List<HomeInfo> baseInfos, List<StorashInfo> selectedInfos) {	
		return HomeMerger.mergeWithStorash(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
