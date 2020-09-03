package br.com.mind5.masterData.weekday.model.action;

import java.util.List;

import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.info.WeekdayMerger;
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;
import br.com.mind5.masterData.weekdaySearch.model.decisionTree.RootWeekdarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiWeekdayMergeWeekdarch extends ActionVisitorTemplateMergeV2<WeekdayInfo, WeekdarchInfo> {
	
	public VisiWeekdayMergeWeekdarch(DeciTreeOption<WeekdayInfo> option) {
		super(option, WeekdarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdarchInfo>> getTreeClassHook() {
		return RootWeekdarchSelect.class;
	}
	
	
	
	@Override protected List<WeekdayInfo> mergeHook(List<WeekdayInfo> baseInfos, List<WeekdarchInfo> selectedInfos) {	
		return WeekdayMerger.mergeWithWeekdarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
