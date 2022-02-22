package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrMerger;

final class VisiStedmonagrMergeToSelect extends ActionVisitorTemplateMerge<StedmonagrInfo, StedmonagrInfo> {
	
	public VisiStedmonagrMergeToSelect(DeciTreeOption<StedmonagrInfo> option) {
		super(option, StedmonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StedmonagrInfo>> getActionClassHook() {
		return StdStedmonagrDaoSelect.class;
	}
	
	
	
	@Override protected List<StedmonagrInfo> mergeHook(List<StedmonagrInfo> baseInfos, List<StedmonagrInfo> selectedInfos) {	
		return StedmonagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
