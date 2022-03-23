package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalCopier;
import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.calendarMoon.model.decisionTree.RootMooncalSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanataVisiMergeMooncal extends ActionVisitorTemplateMerge<PlanataInfo, MooncalInfo> {
	
	public PlanataVisiMergeMooncal(DeciTreeOption<PlanataInfo> option) {
		super(option, MooncalInfo.class);
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
		return super.MERGE_WHEN_EMPTY;
	}
}
