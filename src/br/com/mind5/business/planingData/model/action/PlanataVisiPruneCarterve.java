package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.decisionTree.CarterveRootSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePrune;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanataVisiPruneCarterve extends ActionVisitorTemplatePrune<PlanataInfo, CarterveInfo> {
	
	public PlanataVisiPruneCarterve(DeciTreeOption<PlanataInfo> option) {
		super(option, CarterveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CarterveInfo>> getTreeClassHook() {
		return CarterveRootSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> baseInfos, List<CarterveInfo> selectedInfos) {	
		return PlanataPruner.pruneWithCarterve(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldPruneWhenEmptyHook() {
		return super.PRUNE_WHEN_EMPTY;
	}
}
