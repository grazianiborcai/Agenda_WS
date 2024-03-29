package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.CalateRootSelectMonth;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddMerger;

public final class SteddVisiMergeCalateMonth extends ActionVisitorTemplateMerge<SteddInfo, CalateInfo> {
	
	public SteddVisiMergeCalateMonth(DeciTreeOption<SteddInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return CalateRootSelectMonth.class;
	}
	
	
	
	@Override protected List<SteddInfo> mergeHook(List<SteddInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return SteddMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
