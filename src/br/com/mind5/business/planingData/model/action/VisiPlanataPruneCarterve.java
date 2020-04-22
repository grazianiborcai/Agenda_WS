package br.com.mind5.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.decisionTree.RootCarterveSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePruneV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanataPruneCarterve extends ActionVisitorTemplatePruneV1<PlanataInfo, CarterveInfo> {
	
	public VisiPlanataPruneCarterve(Connection conn, String schemaName) {
		super(conn, schemaName, CarterveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CarterveInfo>> getTreeClassHook() {
		return RootCarterveSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<CarterveInfo> selectedInfos) {	
		return PlanataPruner.pruneWithCarterve(recordInfos, selectedInfos);
	}
}
