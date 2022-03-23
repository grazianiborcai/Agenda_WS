package br.com.mind5.business.planningTime.model.action;

import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;
import br.com.mind5.masterData.moonPhase.info.MoonaseCopier;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.decisionTree.RootMoonaseSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanimeVisiMergeMoonase extends ActionVisitorTemplateMerge<PlanimeInfo, MoonaseInfo> {
	
	public PlanimeVisiMergeMoonase(DeciTreeOption<PlanimeInfo> option) {
		super(option, MoonaseInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MoonaseInfo>> getTreeClassHook() {
		return RootMoonaseSelect.class;
	}
	
	
	
	@Override protected List<MoonaseInfo> toActionClassHook(List<PlanimeInfo> recordInfos) {
		return MoonaseCopier.copyFromPlanime(recordInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> baseInfos, List<MoonaseInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithMoonase(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
