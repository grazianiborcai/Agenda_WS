package br.com.mind5.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalCopier;
import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.moonCalendar.model.decisionTree.RootMooncalSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanataMergeMooncal extends ActionVisitorTemplateMerge<PlanataInfo, MooncalInfo> {
	
	public VisiPlanataMergeMooncal(Connection conn, String schemaName) {
		super(conn, schemaName, MooncalInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MooncalInfo>> getTreeClassHook() {
		return RootMooncalSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> toActionClassHook(List<PlanataInfo> baseInfos) {
		return MooncalCopier.copyFromPlanata(baseInfos);
	}
	
	
	
	@Override protected List<PlanataInfo> mergeHook(List<PlanataInfo> baseInfos, List<MooncalInfo> selectedInfos) {	
		return PlanataMerger.mergeWithMooncal(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}