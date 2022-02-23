package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrMerger;

final class VisiStoronagrMergeToSelect extends ActionVisitorTemplateMerge<StoronagrInfo, StoronagrInfo> {
	
	public VisiStoronagrMergeToSelect(DeciTreeOption<StoronagrInfo> option) {
		super(option, StoronagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoronagrInfo>> getActionClassHook() {
		return StdStoronagrDaoSelect.class;
	}
	
	
	
	@Override protected List<StoronagrInfo> mergeHook(List<StoronagrInfo> baseInfos, List<StoronagrInfo> selectedInfos) {	
		return StoronagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
