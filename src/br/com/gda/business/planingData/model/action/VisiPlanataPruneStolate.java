package br.com.gda.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.info.PlanataPruner;
import br.com.gda.business.storeLeaveDate.info.StolateCopier;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolateSelect;
import br.com.gda.model.action.ActionVisitorTemplatePrune;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPlanataPruneStolate extends ActionVisitorTemplatePrune<PlanataInfo, StolateInfo> {
	
	public VisiPlanataPruneStolate(Connection conn, String schemaName) {
		super(conn, schemaName, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolateInfo>> getTreeClassHook() {
		return RootStolateSelect.class;
	}
	
	
	
	@Override protected List<StolateInfo> toActionClassHook(List<PlanataInfo> recordInfos) {
		return StolateCopier.copyFromPlanata(recordInfos);	
	}	
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<StolateInfo> selectedInfos) {	
		return PlanataPruner.pruneWithStolate(recordInfos, selectedInfos);
	}
}
