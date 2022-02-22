package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveMerger;

final class VisiStedmoniveMergeCalonth extends ActionVisitorTemplateMerge<StedmoniveInfo, CalonthInfo> {
	
	public VisiStedmoniveMergeCalonth(DeciTreeOption<StedmoniveInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return RootCalonthSelect.class;
	}
	
	
	
	@Override protected List<StedmoniveInfo> mergeHook(List<StedmoniveInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return StedmoniveMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
