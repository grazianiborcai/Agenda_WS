package br.com.mind5.business.planningTime.model.action;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataCopier;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.decisionTree.RootPlanataSelect;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanimeMergePlanata extends ActionVisitorTemplateMerge<PlanimeInfo, PlanataInfo> {
	
	public VisiPlanimeMergePlanata(DeciTreeOption<PlanimeInfo> option) {
		super(option, PlanataInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PlanataInfo>> getTreeClassHook() {
		return RootPlanataSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> toActionClassHook(List<PlanimeInfo> baseInfos) {
		return PlanataCopier.copyFromPlanime(baseInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> baseInfos, List<PlanataInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithPlanata(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
