package br.com.mind5.business.storeLunchTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapMerger;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.WeekdayRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmapVisiMergeWeekday extends ActionVisitorTemplateMerge<StuntmapInfo, WeekdayInfo> {
	
	public StuntmapVisiMergeWeekday(DeciTreeOption<StuntmapInfo> option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return WeekdayRootSelect.class;
	}
	
	
	
	@Override protected List<StuntmapInfo> mergeHook(List<StuntmapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {	
		return StuntmapMerger.mergeWithWeekday(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
