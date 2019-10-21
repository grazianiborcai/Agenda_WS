package br.com.mind5.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.decisionTree.RootOrderveSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePrune;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanataPruneOrderve extends ActionVisitorTemplatePrune<PlanataInfo, OrderveInfo> {
	
	public VisiPlanataPruneOrderve(Connection conn, String schemaName) {
		super(conn, schemaName, OrderveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderveInfo>> getTreeClassHook() {
		return RootOrderveSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<OrderveInfo> selectedInfos) {	
		return PlanataPruner.pruneWithOrderve(recordInfos, selectedInfos);
	}
}
