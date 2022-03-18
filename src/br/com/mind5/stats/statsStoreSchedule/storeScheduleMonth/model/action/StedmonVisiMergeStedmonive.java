package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonMerger;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.decisionTree.StedmoniveRootSelect;

public final class StedmonVisiMergeStedmonive extends ActionVisitorTemplateMerge<StedmonInfo, StedmoniveInfo> {
	
	public StedmonVisiMergeStedmonive(DeciTreeOption<StedmonInfo> option) {
		super(option, StedmoniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StedmoniveInfo>> getTreeClassHook() {
		return StedmoniveRootSelect.class;
	}
	
	
	
	@Override protected List<StedmonInfo> mergeHook(List<StedmonInfo> baseInfos, List<StedmoniveInfo> selectedInfos) {	
		return StedmonMerger.mergeWithStedmonive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
