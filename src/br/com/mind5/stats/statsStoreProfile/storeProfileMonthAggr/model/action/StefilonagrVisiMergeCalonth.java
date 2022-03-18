package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrMerger;

public final class StefilonagrVisiMergeCalonth extends ActionVisitorTemplateMerge<StefilonagrInfo, CalonthInfo> {
	
	public StefilonagrVisiMergeCalonth(DeciTreeOption<StefilonagrInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelect.class;
	}
	
	
	
	@Override protected List<StefilonagrInfo> mergeHook(List<StefilonagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return StefilonagrMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
