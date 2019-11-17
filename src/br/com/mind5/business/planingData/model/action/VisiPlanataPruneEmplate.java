package br.com.mind5.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateCopier;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplateSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePrune;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanataPruneEmplate extends ActionVisitorTemplatePrune<PlanataInfo, EmplateInfo> {
	
	public VisiPlanataPruneEmplate(Connection conn, String schemaName) {
		super(conn, schemaName, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplateInfo>> getTreeClassHook() {
		return RootEmplateSelect.class;
	}
	
	
	
	@Override protected List<EmplateInfo> toActionClassHook(List<PlanataInfo> recordInfos) {
		return EmplateCopier.copyFromPlanata(recordInfos);	
	}	
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<EmplateInfo> selectedInfos) {	
		return PlanataPruner.pruneWithEmplate(recordInfos, selectedInfos);
	}
}
