package br.com.gda.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderReserve.info.OrderveInfo;
import br.com.gda.business.orderReserve.model.decisionTree.RootOrderveSelect;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.info.PlanataPruner;
import br.com.gda.model.action.ActionVisitorTemplatePrune;
import br.com.gda.model.decisionTree.DeciTree;

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
