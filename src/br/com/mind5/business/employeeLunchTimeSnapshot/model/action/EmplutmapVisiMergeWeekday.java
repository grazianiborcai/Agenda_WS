package br.com.mind5.business.employeeLunchTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapInfo;
import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapMerger;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.WeekdayRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmapVisiMergeWeekday extends ActionVisitorTemplateMerge<EmplutmapInfo, WeekdayInfo> {
	
	public EmplutmapVisiMergeWeekday(DeciTreeOption<EmplutmapInfo> option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return WeekdayRootSelect.class;
	}
	
	
	
	@Override protected List<EmplutmapInfo> mergeHook(List<EmplutmapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {	
		return EmplutmapMerger.mergeWithWeekday(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
