package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrMerger;

final class VisiStordagrMergeToSelect extends ActionVisitorTemplateMerge<StordagrInfo, StordagrInfo> {
	
	public VisiStordagrMergeToSelect(DeciTreeOption<StordagrInfo> option) {
		super(option, StordagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StordagrInfo>> getActionClassHook() {
		return StdStordagrDaoSelect.class;
	}
	
	
	
	@Override protected List<StordagrInfo> mergeHook(List<StordagrInfo> baseInfos, List<StordagrInfo> selectedInfos) {	
		return StordagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
