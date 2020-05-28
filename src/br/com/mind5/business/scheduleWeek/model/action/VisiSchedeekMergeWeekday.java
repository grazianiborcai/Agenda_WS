package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.masterData.weekday.info.WeekdayCopier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedeekMergeWeekday extends ActionVisitorTemplateMergeV2<SchedeekInfo, WeekdayInfo> {
	
	public VisiSchedeekMergeWeekday(DeciTreeOption<SchedeekInfo> option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<WeekdayInfo> toActionClassHook(List<SchedeekInfo> recordInfos) {
		return WeekdayCopier.copyFromSchedeek(recordInfos);
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<WeekdayInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithWeekday(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
