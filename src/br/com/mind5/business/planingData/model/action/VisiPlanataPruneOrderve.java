package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.decisionTree.RootOrderveSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanataPruneOrderve extends ActionVisitorTemplatePruneV2<PlanataInfo, OrderveInfo> {
	
	public VisiPlanataPruneOrderve(DeciTreeOption<PlanataInfo> option) {
		super(option, OrderveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderveInfo>> getTreeClassHook() {
		return RootOrderveSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<OrderveInfo> selectedInfos) {	
		return PlanataPruner.pruneWithOrderve(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldPruneWhenEmptyHook() {
		return super.PRUNE_WHEN_EMPTY;
	}
}
