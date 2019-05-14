package br.com.gda.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.WeekdayCopier;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.business.planningTime.info.PlanimeMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPlanimeMergeWeekday extends ActionVisitorTemplateMergeV2<PlanimeInfo, WeekdayInfo> {
	
	public VisiPlanimeMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<WeekdayInfo> toActionClassHook(List<PlanimeInfo> recordInfos) {
		return WeekdayCopier.copyFromPlanime(recordInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> recordInfos, List<WeekdayInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithWeekday(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
