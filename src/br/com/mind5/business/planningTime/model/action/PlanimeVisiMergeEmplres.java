package br.com.mind5.business.planningTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresCopier;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.employeeRestricted.model.decisionTree.RootEmplresSelect;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanimeVisiMergeEmplres extends ActionVisitorTemplateMerge<PlanimeInfo, EmplresInfo> {
	
	public PlanimeVisiMergeEmplres(DeciTreeOption<PlanimeInfo> option) {
		super(option, EmplresInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplresInfo>> getTreeClassHook() {
		return RootEmplresSelect.class;
	}
	
	
	
	@Override protected List<EmplresInfo> toActionClassHook(List<PlanimeInfo> baseInfos) {
		return EmplresCopier.copyFromPlanime(baseInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> baseInfos, List<EmplresInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithEmplres(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
