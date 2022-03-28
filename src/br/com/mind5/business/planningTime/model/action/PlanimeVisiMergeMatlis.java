package br.com.mind5.business.planningTime.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisCopier;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.MatlisRootSelect;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanimeVisiMergeMatlis extends ActionVisitorTemplateMerge<PlanimeInfo, MatlisInfo> {
	
	public PlanimeVisiMergeMatlis(DeciTreeOption<PlanimeInfo> option) {
		super(option, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return MatlisRootSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> toActionClassHook(List<PlanimeInfo> baseInfos) {
		return MatlisCopier.copyFromPlanime(baseInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> baseInfos, List<MatlisInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithMatlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
