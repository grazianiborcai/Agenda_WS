package br.com.mind5.stats.statsOwnerDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashMerger;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.decisionTree.SowalRootSelect;

final class VisiSowashMergeSowal extends ActionVisitorTemplateMerge<SowashInfo, SowalInfo> {
	
	public VisiSowashMergeSowal(DeciTreeOption<SowashInfo> option) {
		super(option, SowalInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowalInfo>> getTreeClassHook() {
		return SowalRootSelect.class;
	}
	
	
	
	@Override protected List<SowashInfo> mergeHook(List<SowashInfo> baseInfos, List<SowalInfo> selectedInfos) {	
		return SowashMerger.mergeWithSowal(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
