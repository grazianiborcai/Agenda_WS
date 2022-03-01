package br.com.mind5.stats.statsOwnerDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashMerger;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.decisionTree.SowotRootSelectLtm;

final class VisiSowashMergeSowot extends ActionVisitorTemplateMerge<SowashInfo, SowotInfo> {
	
	public VisiSowashMergeSowot(DeciTreeOption<SowashInfo> option) {
		super(option, SowotInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotInfo>> getTreeClassHook() {
		return SowotRootSelectLtm.class;
	}
	
	
	
	@Override protected List<SowashInfo> mergeHook(List<SowashInfo> baseInfos, List<SowotInfo> selectedInfos) {	
		return SowashMerger.mergeWithSowot(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
