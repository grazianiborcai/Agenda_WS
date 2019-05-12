package br.com.gda.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.info.PlanataPruner;
import br.com.gda.business.storeLeaveDate.info.StolevateCopier;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStolevateSelect;
import br.com.gda.model.action.ActionVisitorTemplatePrune;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPlanataPruneStolevate extends ActionVisitorTemplatePrune<PlanataInfo, StolevateInfo> {
	
	public VisiPlanataPruneStolevate(Connection conn, String schemaName) {
		super(conn, schemaName, StolevateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolevateInfo>> getTreeClassHook() {
		return RootStolevateSelect.class;
	}
	
	
	
	@Override protected List<StolevateInfo> toActionClassHook(List<PlanataInfo> recordInfos) {
		return StolevateCopier.copyFromPlanata(recordInfos);	
	}	
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<StolevateInfo> selectedInfos) {	
		return PlanataPruner.pruneWithStolevate(recordInfos, selectedInfos);
	}
}
