package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronMerger;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.decisionTree.RootStoronagrSelect;

final class VisiStoronMergeStoronagr extends ActionVisitorTemplateMerge<StoronInfo, StoronagrInfo> {
	
	public VisiStoronMergeStoronagr(DeciTreeOption<StoronInfo> option) {
		super(option, StoronagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoronagrInfo>> getTreeClassHook() {
		return RootStoronagrSelect.class;
	}
	
	
	
	@Override protected List<StoronInfo> mergeHook(List<StoronInfo> baseInfos, List<StoronagrInfo> selectedInfos) {	
		return StoronMerger.mergeWithStoronagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
