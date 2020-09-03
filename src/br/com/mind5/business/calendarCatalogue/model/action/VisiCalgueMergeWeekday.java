package br.com.mind5.business.calendarCatalogue.model.action;

import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogue.info.CalgueMerger;
import br.com.mind5.masterData.weekday.info.WeekdayCopier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalgueMergeWeekday extends ActionVisitorTemplateMergeV2<CalgueInfo, WeekdayInfo> {
	
	public VisiCalgueMergeWeekday(DeciTreeOption<CalgueInfo> option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<CalgueInfo> mergeHook(List<CalgueInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		return CalgueMerger.mergeWithWeekday(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected List<WeekdayInfo> toActionClassHook(List<CalgueInfo> baseInfos) {
		return WeekdayCopier.copyFromCalgue(baseInfos);	
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
