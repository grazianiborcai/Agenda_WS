package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrMerger;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.decisionTree.SowotarchRootSelectMonth;

public final class SowotagrVisiMergeSowotarchMonth extends ActionVisitorTemplateMerge<SowotagrInfo, SowotarchInfo> {
	
	public SowotagrVisiMergeSowotarchMonth(DeciTreeOption<SowotagrInfo> option) {
		super(option, SowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowotarchInfo>> getTreeClassHook() {
		return SowotarchRootSelectMonth.class;
	}
	
	
	
	@Override protected List<SowotagrInfo> mergeHook(List<SowotagrInfo> baseInfos, List<SowotarchInfo> selectedInfos) {	
		return SowotagrMerger.mergeWithSowotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
