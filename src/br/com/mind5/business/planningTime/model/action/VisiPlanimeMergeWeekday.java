package br.com.mind5.business.planningTime.model.action;

import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;
import br.com.mind5.masterData.weekday.info.WeekdayCopier;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.RootWeekdaySelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanimeMergeWeekday extends ActionVisitorTemplateMerge<PlanimeInfo, WeekdayInfo> {
	
	public VisiPlanimeMergeWeekday(DeciTreeOption<PlanimeInfo> option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<WeekdayInfo> toActionClassHook(List<PlanimeInfo> baseInfos) {
		return WeekdayCopier.copyFromPlanime(baseInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> baseInfos, List<WeekdayInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithWeekday(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
