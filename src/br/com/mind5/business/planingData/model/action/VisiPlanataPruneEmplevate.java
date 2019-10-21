package br.com.mind5.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateCopier;
import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplevateSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.model.action.ActionVisitorTemplatePrune;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanataPruneEmplevate extends ActionVisitorTemplatePrune<PlanataInfo, EmplevateInfo> {
	
	public VisiPlanataPruneEmplevate(Connection conn, String schemaName) {
		super(conn, schemaName, EmplevateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplevateInfo>> getTreeClassHook() {
		return RootEmplevateSelect.class;
	}
	
	
	
	@Override protected List<EmplevateInfo> toActionClassHook(List<PlanataInfo> recordInfos) {
		return EmplevateCopier.copyFromPlanata(recordInfos);	
	}	
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<EmplevateInfo> selectedInfos) {	
		return PlanataPruner.pruneWithEmplevate(recordInfos, selectedInfos);
	}
}
