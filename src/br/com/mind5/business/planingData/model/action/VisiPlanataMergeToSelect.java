package br.com.mind5.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiPlanataMergeToSelect extends ActionVisitorTemplateMergeV2<PlanataInfo, PlanataInfo> {
	
	public VisiPlanataMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PlanataInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PlanataInfo>> getActionClassHook() {
		return StdPlanataSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> mergeHook(List<PlanataInfo> recordInfos, List<PlanataInfo> selectedInfos) {	
		return PlanataMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
