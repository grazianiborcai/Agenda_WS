package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.business.storeLeaveDate.info.StolateCopier;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.StolateRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplatePrune;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanataVisiPruneStolate extends ActionVisitorTemplatePrune<PlanataInfo, StolateInfo> {
	
	public PlanataVisiPruneStolate(DeciTreeOption<PlanataInfo> option) {
		super(option, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolateInfo>> getTreeClassHook() {
		return StolateRootSearch.class;
	}
	
	
	
	@Override protected List<StolateInfo> toActionClassHook(List<PlanataInfo> recordInfos) {
		return StolateCopier.copyFromPlanata(recordInfos);	
	}	
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<StolateInfo> selectedInfos) {	
		return PlanataPruner.pruneWithStolate(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldPruneWhenEmptyHook() {
		return super.PRUNE_WHEN_EMPTY;
	}
}
