package br.com.mind5.stats.statsOwnerDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashMerger;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUser.model.decisionTree.RootSowusSelectLtm;

final class VisiSowashMergeSowus extends ActionVisitorTemplateMerge<SowashInfo, SowusInfo> {
	
	public VisiSowashMergeSowus(DeciTreeOption<SowashInfo> option) {
		super(option, SowusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusInfo>> getTreeClassHook() {
		return RootSowusSelectLtm.class;
	}
	
	
	
	@Override protected List<SowashInfo> mergeHook(List<SowashInfo> baseInfos, List<SowusInfo> selectedInfos) {	
		return SowashMerger.mergeWithSowus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
