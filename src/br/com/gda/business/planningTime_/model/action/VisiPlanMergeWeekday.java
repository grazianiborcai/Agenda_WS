package br.com.gda.business.planningTime_.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.business.planningTime_.info.PlanMerger;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPlanMergeWeekday extends ActionVisitorTemplateMerge<PlanInfo, WeekdayInfo> {
	
	public VisiPlanMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<PlanInfo> mergeHook(List<PlanInfo> recordInfos, List<WeekdayInfo> selectedInfos) {	
		return PlanMerger.mergeWithWeekday(selectedInfos, recordInfos);
	}
}
