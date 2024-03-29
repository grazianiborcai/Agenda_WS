package br.com.mind5.stats.statsOwnerDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashMerger;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.decisionTree.SowusRootSelectLtm;

public final class SowashVisiMergeSowus extends ActionVisitorTemplateMerge<SowashInfo, SowusInfo> {
	
	public SowashVisiMergeSowus(DeciTreeOption<SowashInfo> option) {
		super(option, SowusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusInfo>> getTreeClassHook() {
		return SowusRootSelectLtm.class;
	}
	
	
	
	@Override protected List<SowashInfo> mergeHook(List<SowashInfo> baseInfos, List<SowusInfo> selectedInfos) {	
		return SowashMerger.mergeWithSowus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
