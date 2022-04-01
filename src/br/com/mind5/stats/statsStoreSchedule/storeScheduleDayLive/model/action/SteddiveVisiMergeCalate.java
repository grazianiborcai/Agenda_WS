package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.CalateRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveMerger;

public final class SteddiveVisiMergeCalate extends ActionVisitorTemplateMerge<SteddiveInfo, CalateInfo> {
	
	public SteddiveVisiMergeCalate(DeciTreeOption<SteddiveInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return CalateRootSelect.class;
	}
	
	
	
	@Override protected List<SteddiveInfo> mergeHook(List<SteddiveInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return SteddiveMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
