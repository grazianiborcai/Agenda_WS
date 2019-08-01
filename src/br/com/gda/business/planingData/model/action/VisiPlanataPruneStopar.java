package br.com.gda.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.info.PlanataPruner;
import br.com.gda.model.action.ActionVisitorTemplatePrune;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.storePartner.info.StoparCopier;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.decisionTree.RootStoparSelect;

final class VisiPlanataPruneStopar extends ActionVisitorTemplatePrune<PlanataInfo, StoparInfo> {
	
	public VisiPlanataPruneStopar(Connection conn, String schemaName) {
		super(conn, schemaName, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparInfo>> getTreeClassHook() {
		return RootStoparSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> toActionClassHook(List<PlanataInfo> recordInfos) {
		return StoparCopier.copyFromPlanata(recordInfos);	
	}	
	
	
	
	@Override protected List<PlanataInfo> pruneHook(List<PlanataInfo> recordInfos, List<StoparInfo> selectedInfos) {	
		return PlanataPruner.pruneWithStopar(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldPruneWhenEmptyHook() {
		return ActionVisitorTemplatePrune.PRUNE_WHEN_EMPTY;
	}
}
