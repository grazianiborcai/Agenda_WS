package br.com.gda.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cartReserve.info.CarterveInfo;
import br.com.gda.business.cartReserve.model.decisionTree.RootCarterveSelect;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.info.PlanataPruner;
import br.com.gda.model.action.ActionVisitorTemplatePrune;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPlanataPruneCarterve extends ActionVisitorTemplatePrune<PlanataInfo, CarterveInfo> {
	
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
