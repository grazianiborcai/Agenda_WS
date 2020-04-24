package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateCopier;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplateSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanataPruneEmplate extends ActionVisitorTemplatePruneV2<PlanataInfo, EmplateInfo> {
	
	public VisiPlanataPruneEmplate(DeciTreeOption<PlanataInfo> option) {
		super(option, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplateInfo>> getTreeClassHook() {
		return RootEmplateSelect.class;
	}
	
	
	
	@Override protected List<EmplateInfo> toActionClassHook(List<PlanataInfo> recordInfos) {
		return EmplateCopier.copyFromPlanata(recordInfos);	
	}	
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<EmplateInfo> selectedInfos) {	
		return PlanataPruner.pruneWithEmplate(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldPruneWhenEmptyHook() {
		return super.PRUNE_WHEN_EMPTY;
	}
}
