package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveMerger;

public final class StedmoniveVisiMergeToSelect extends ActionVisitorTemplateMerge<StedmoniveInfo, StedmoniveInfo> {
	
	public StedmoniveVisiMergeToSelect(DeciTreeOption<StedmoniveInfo> option) {
		super(option, StedmoniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StedmoniveInfo>> getVisitorClassHook() {
		return StedmoniveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StedmoniveInfo> mergeHook(List<StedmoniveInfo> baseInfos, List<StedmoniveInfo> selectedInfos) {	
		return StedmoniveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
