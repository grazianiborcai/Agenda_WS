package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrMerger;

public final class StoronagrVisiMergeCalonth extends ActionVisitorTemplateMerge<StoronagrInfo, CalonthInfo> {
	
	public StoronagrVisiMergeCalonth(DeciTreeOption<StoronagrInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelect.class;
	}
	
	
	
	@Override protected List<StoronagrInfo> mergeHook(List<StoronagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return StoronagrMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
