package br.com.mind5.business.planingData.model.action;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.decisionTree.RootCarterveSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPlanataPruneCarterve extends ActionVisitorTemplatePruneV2<PlanataInfo, CarterveInfo> {
	
	public VisiPlanataPruneCarterve(DeciTreeOption<PlanataInfo> option) {
		super(option, CarterveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CarterveInfo>> getTreeClassHook() {
		return RootCarterveSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> baseInfos, List<CarterveInfo> selectedInfos) {	
		return PlanataPruner.pruneWithCarterve(baseInfos, selectedInfos);
	}
}
