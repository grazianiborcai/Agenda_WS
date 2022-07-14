package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrMerger;

public final class StoronagrVisiMergeToSelect extends ActionVisitorTemplateMerge<StoronagrInfo, StoronagrInfo> {
	
	public StoronagrVisiMergeToSelect(DeciTreeOption<StoronagrInfo> option) {
		super(option, StoronagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoronagrInfo>> getVisitorClassHook() {
		return StoronagrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoronagrInfo> mergeHook(List<StoronagrInfo> baseInfos, List<StoronagrInfo> selectedInfos) {	
		return StoronagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
