package br.com.mind5.business.planningTime.model.action;

import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;
import br.com.mind5.business.storeList.info.StolisCopier;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.StolisRootSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanimeVisiMergeStolis extends ActionVisitorTemplateMerge<PlanimeInfo, StolisInfo> {
	
	public PlanimeVisiMergeStolis(DeciTreeOption<PlanimeInfo> option) {
		super(option, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return StolisRootSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> toActionClassHook(List<PlanimeInfo> baseInfos) {
		return StolisCopier.copyFromPlanime(baseInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
