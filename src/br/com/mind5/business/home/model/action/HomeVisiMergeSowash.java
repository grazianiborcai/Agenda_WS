package br.com.mind5.business.home.model.action;

import java.util.List;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.info.HomeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.model.decisionTree.SowashRootSelectNow;

public final class HomeVisiMergeSowash extends ActionVisitorTemplateMerge<HomeInfo, SowashInfo> {
	
	public HomeVisiMergeSowash(DeciTreeOption<HomeInfo> option) {
		super(option, SowashInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowashInfo>> getTreeClassHook() {
		return SowashRootSelectNow.class;
	}
	
	
	
	@Override protected List<HomeInfo> mergeHook(List<HomeInfo> baseInfos, List<SowashInfo> selectedInfos) {	
		return HomeMerger.mergeWithSowash(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
