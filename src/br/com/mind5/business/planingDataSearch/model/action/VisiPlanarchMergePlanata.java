package br.com.mind5.business.planingDataSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.decisionTree.RootPlanataSelectNoReserve;
import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.business.planingDataSearch.info.PlanarchMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanarchMergePlanata extends ActionVisitorTemplateMerge<PlanarchInfo, PlanataInfo> {
	
	public VisiPlanarchMergePlanata(Connection conn, String schemaName) {
		super(conn, schemaName, PlanataInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PlanataInfo>> getTreeClassHook() {
		return RootPlanataSelectNoReserve.class;
	}
	
	
	
	@Override protected List<PlanarchInfo> mergeHook(List<PlanarchInfo> baseInfos, List<PlanataInfo> selectedInfos) {	
		return PlanarchMerger.mergeWithPlanata(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
