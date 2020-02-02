package br.com.mind5.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataCopier;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.decisionTree.RootPlanataSelect;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanimeMergePlanata extends ActionVisitorTemplateMergeV2<PlanimeInfo, PlanataInfo> {
	
	public VisiPlanimeMergePlanata(Connection conn, String schemaName) {
		super(conn, schemaName, PlanataInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PlanataInfo>> getTreeClassHook() {
		return RootPlanataSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> toActionClassHook(List<PlanimeInfo> baseInfos) {
		return PlanataCopier.copyFromPlanime(baseInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> baseInfos, List<PlanataInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithPlanata(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
