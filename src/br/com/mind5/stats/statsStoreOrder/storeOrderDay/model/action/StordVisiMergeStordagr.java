package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordMerger;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.decisionTree.StordagrRootSelect;

public final class StordVisiMergeStordagr extends ActionVisitorTemplateMerge<StordInfo, StordagrInfo> {
	
	public StordVisiMergeStordagr(DeciTreeOption<StordInfo> option) {
		super(option, StordagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StordagrInfo>> getTreeClassHook() {
		return StordagrRootSelect.class;
	}
	
	
	
	@Override protected List<StordInfo> mergeHook(List<StordInfo> baseInfos, List<StordagrInfo> selectedInfos) {	
		return StordMerger.mergeWithStordagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
