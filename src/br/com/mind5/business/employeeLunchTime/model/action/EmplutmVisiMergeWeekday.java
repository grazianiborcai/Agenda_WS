package br.com.mind5.business.employeeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.info.EmplutmMerger;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmVisiMergeWeekday extends ActionVisitorTemplateMerge<EmplutmInfo, WeekdayInfo> {
	
	public EmplutmVisiMergeWeekday(DeciTreeOption<EmplutmInfo> option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<EmplutmInfo> mergeHook(List<EmplutmInfo> baseInfos, List<WeekdayInfo> selectedInfos) {	
		return EmplutmMerger.mergeWithWeekday(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
