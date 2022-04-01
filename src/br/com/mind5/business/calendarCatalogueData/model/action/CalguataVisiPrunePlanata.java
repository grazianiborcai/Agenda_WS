package br.com.mind5.business.calendarCatalogueData.model.action;

import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarCatalogueData.info.CalguataPruner;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.decisionTree.PlanataRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplatePrune;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalguataVisiPrunePlanata extends ActionVisitorTemplatePrune<CalguataInfo, PlanataInfo> {
	
	public CalguataVisiPrunePlanata(DeciTreeOption<CalguataInfo> option) {
		super(option, PlanataInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PlanataInfo>> getTreeClassHook() {
		return PlanataRootSelect.class;
	}
	
	
	
	@Override protected List<CalguataInfo> pruneHook(List<CalguataInfo> baseInfos, List<PlanataInfo> selectedInfos) {	
		return CalguataPruner.pruneWithPlanata(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldPruneWhenEmptyHook() {
		return super.DONT_PRUNE_WHEN_EMPTY;
	}
}
