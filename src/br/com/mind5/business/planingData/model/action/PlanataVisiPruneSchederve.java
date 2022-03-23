package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.model.decisionTree.RootSchederveSelect;
import br.com.mind5.model.action.ActionVisitorTemplatePrune;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanataVisiPruneSchederve extends ActionVisitorTemplatePrune<PlanataInfo, SchederveInfo> {
	
	public PlanataVisiPruneSchederve(DeciTreeOption<PlanataInfo> option) {
		super(option, SchederveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchederveInfo>> getTreeClassHook() {
		return RootSchederveSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> baseInfos, List<SchederveInfo> selectedInfos) {	
		return PlanataPruner.pruneWithSchederve(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldPruneWhenEmptyHook() {
		return super.PRUNE_WHEN_EMPTY;
	}
}
