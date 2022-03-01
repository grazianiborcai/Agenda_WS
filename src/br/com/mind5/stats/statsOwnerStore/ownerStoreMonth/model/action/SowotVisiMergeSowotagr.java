package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotMerger;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.decisionTree.SowotagrRootSelect;

public final class SowotVisiMergeSowotagr extends ActionVisitorTemplateMerge<SowotInfo, SowotagrInfo> {
	
	public SowotVisiMergeSowotagr(DeciTreeOption<SowotInfo> option) {
		super(option, SowotagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotagrInfo>> getTreeClassHook() {
		return SowotagrRootSelect.class;
	}
	
	
	
	@Override protected List<SowotInfo> mergeHook(List<SowotInfo> baseInfos, List<SowotagrInfo> selectedInfos) {	
		return SowotMerger.mergeWithSowotagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
