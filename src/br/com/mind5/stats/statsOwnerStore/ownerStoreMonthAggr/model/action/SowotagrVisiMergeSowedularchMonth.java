package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrMerger;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.decisionTree.SowedularchRootSelectMonth;

public final class SowotagrVisiMergeSowedularchMonth extends ActionVisitorTemplateMerge<SowotagrInfo, SowedularchInfo> {
	
	public SowotagrVisiMergeSowedularchMonth(DeciTreeOption<SowotagrInfo> option) {
		super(option, SowedularchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowedularchInfo>> getTreeClassHook() {
		return SowedularchRootSelectMonth.class;
	}
	
	
	
	@Override protected List<SowotagrInfo> mergeHook(List<SowotagrInfo> baseInfos, List<SowedularchInfo> selectedInfos) {	
		return SowotagrMerger.mergeWithSowedularch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
