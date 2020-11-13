package br.com.mind5.business.planningTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisCopier;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanimeMergeEmplis extends ActionVisitorTemplateMerge<PlanimeInfo, EmplisInfo> {
	
	public VisiPlanimeMergeEmplis(DeciTreeOption<PlanimeInfo> option) {
		super(option, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return RootEmplisSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> toActionClassHook(List<PlanimeInfo> baseInfos) {
		return EmplisCopier.copyFromPlanime(baseInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> baseInfos, List<EmplisInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithEmplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
