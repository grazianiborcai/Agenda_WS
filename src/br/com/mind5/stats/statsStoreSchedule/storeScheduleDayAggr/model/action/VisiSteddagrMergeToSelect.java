package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrMerger;

final class VisiSteddagrMergeToSelect extends ActionVisitorTemplateMerge<SteddagrInfo, SteddagrInfo> {
	
	public VisiSteddagrMergeToSelect(DeciTreeOption<SteddagrInfo> option) {
		super(option, SteddagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SteddagrInfo>> getActionClassHook() {
		return StdSteddagrDaoSelect.class;
	}
	
	
	
	@Override protected List<SteddagrInfo> mergeHook(List<SteddagrInfo> baseInfos, List<SteddagrInfo> selectedInfos) {	
		return SteddagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
