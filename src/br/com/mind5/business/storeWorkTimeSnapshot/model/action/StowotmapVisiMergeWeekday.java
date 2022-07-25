package br.com.mind5.business.storeWorkTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapMerger;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.WeekdayRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmapVisiMergeWeekday extends ActionVisitorTemplateMerge<StowotmapInfo, WeekdayInfo> {
	
	public StowotmapVisiMergeWeekday(DeciTreeOption<StowotmapInfo> option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return WeekdayRootSelect.class;
	}
	
	
	
	@Override protected List<StowotmapInfo> mergeHook(List<StowotmapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {	
		return StowotmapMerger.mergeWithWeekday(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
