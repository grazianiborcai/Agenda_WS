package br.com.mind5.business.scheduleMonthData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatMerger;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedonthatMergeWeekday extends ActionVisitorTemplateMergeV2<SchedonthatInfo, WeekdayInfo> {

	public VisiSchedonthatMergeWeekday(DeciTreeOption<SchedonthatInfo> option) {
		super(option, WeekdayInfo.class);
	}

	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}

	
	
	@Override protected List<SchedonthatInfo> mergeHook(List<SchedonthatInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		return SchedonthatMerger.mergeWithWeekday(baseInfos, selectedInfos);
	}

	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
