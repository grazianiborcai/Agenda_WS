package br.com.gda.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataCopier;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.model.decisionTree.RootPlanataSelect;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.business.planningTime.info.PlanimeMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPlanimeMergePlanata extends ActionVisitorTemplateMergeV2<PlanimeInfo, PlanataInfo> {
	
	public VisiPlanimeMergePlanata(Connection conn, String schemaName) {
		super(conn, schemaName, PlanataInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PlanataInfo>> getTreeClassHook() {
		return RootPlanataSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> toActionClassHook(List<PlanimeInfo> recordInfos) {
		return PlanataCopier.copyFromPlanime(recordInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> recordInfos, List<PlanataInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithPlanata(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
