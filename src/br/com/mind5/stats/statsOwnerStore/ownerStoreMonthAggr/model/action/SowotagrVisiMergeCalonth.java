package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrMerger;

public final class SowotagrVisiMergeCalonth extends ActionVisitorTemplateMerge<SowotagrInfo, CalonthInfo> {
	
	public SowotagrVisiMergeCalonth(DeciTreeOption<SowotagrInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return RootCalonthSelect.class;
	}
	
	
	
	@Override protected List<SowotagrInfo> mergeHook(List<SowotagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return SowotagrMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
