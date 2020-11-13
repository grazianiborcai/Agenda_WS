package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePrune;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisCopier;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.decisionTree.RootStoplisSearch;

final class VisiPlanataPruneStoplis extends ActionVisitorTemplatePrune<PlanataInfo, StoplisInfo> {
	
	public VisiPlanataPruneStoplis(DeciTreeOption<PlanataInfo> option) {
		super(option, StoplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoplisInfo>> getTreeClassHook() {
		return RootStoplisSearch.class;
	}
	
	
	
	@Override protected List<StoplisInfo> toActionClassHook(List<PlanataInfo> recordInfos) {
		return StoplisCopier.copyFromPlanata(recordInfos);	
	}	
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<StoplisInfo> selectedInfos) {	
		return PlanataPruner.pruneWithStoplis(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldPruneWhenEmptyHook() {
		return super.PRUNE_WHEN_EMPTY;
	}
}
