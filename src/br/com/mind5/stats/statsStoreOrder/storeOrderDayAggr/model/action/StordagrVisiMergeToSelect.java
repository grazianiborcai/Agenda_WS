package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrMerger;

public final class StordagrVisiMergeToSelect extends ActionVisitorTemplateMerge<StordagrInfo, StordagrInfo> {
	
	public StordagrVisiMergeToSelect(DeciTreeOption<StordagrInfo> option) {
		super(option, StordagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StordagrInfo>> getVisitorClassHook() {
		return StordagrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StordagrInfo> mergeHook(List<StordagrInfo> baseInfos, List<StordagrInfo> selectedInfos) {	
		return StordagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
