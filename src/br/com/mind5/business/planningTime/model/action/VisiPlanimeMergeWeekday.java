package br.com.mind5.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.WeekdayCopier;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanimeMergeWeekday extends ActionVisitorTemplateMergeV2<PlanimeInfo, WeekdayInfo> {
	
	public VisiPlanimeMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<WeekdayInfo> toActionClassHook(List<PlanimeInfo> baseInfos) {
		return WeekdayCopier.copyFromPlanime(baseInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> baseInfos, List<WeekdayInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithWeekday(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
