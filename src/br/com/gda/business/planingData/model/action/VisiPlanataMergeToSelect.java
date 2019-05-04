package br.com.gda.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.info.PlanataMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMerge;

final class VisiPlanataMergeToSelect extends ActionVisitorTemplateMerge<PlanataInfo, PlanataInfo> {
	
	public VisiPlanataMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PlanataInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PlanataInfo>> getActionClassHook() {
		return StdPlanataSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> mergeHook(List<PlanataInfo> recordInfos, List<PlanataInfo> selectedInfos) {	
		return PlanataMerger.mergeToSelect(selectedInfos, recordInfos);
	}
}
