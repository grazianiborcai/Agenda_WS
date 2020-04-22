package br.com.mind5.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataPruner;
import br.com.mind5.business.storeLeaveDate.info.StolateCopier;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.RootStolateSelect;
import br.com.mind5.model.action.ActionVisitorTemplatePruneV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanataPruneStolate extends ActionVisitorTemplatePruneV1<PlanataInfo, StolateInfo> {
	
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
