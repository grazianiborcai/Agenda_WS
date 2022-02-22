package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonMerger;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.decisionTree.RootStedmonagrSelect;

final class VisiStedmonMergeStedmonagr extends ActionVisitorTemplateMerge<StedmonInfo, StedmonagrInfo> {
	
	public VisiStedmonMergeStedmonagr(DeciTreeOption<StedmonInfo> option) {
		super(option, StedmonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StedmonagrInfo>> getTreeClassHook() {
		return RootStedmonagrSelect.class;
	}
	
	
	
	@Override protected List<StedmonInfo> mergeHook(List<StedmonInfo> baseInfos, List<StedmonagrInfo> selectedInfos) {	
		return StedmonMerger.mergeWithStedmonagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
