package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.RootCalateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrMerger;

public final class SteddagrVisiMergeCalate extends ActionVisitorTemplateMerge<SteddagrInfo, CalateInfo> {
	
	public SteddagrVisiMergeCalate(DeciTreeOption<SteddagrInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return RootCalateSelect.class;
	}
	
	
	
	@Override protected List<SteddagrInfo> mergeHook(List<SteddagrInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return SteddagrMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
