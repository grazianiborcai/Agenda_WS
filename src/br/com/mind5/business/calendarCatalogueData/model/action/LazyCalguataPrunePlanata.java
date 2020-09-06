package br.com.mind5.business.calendarCatalogueData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCalguataPrunePlanata extends ActionLazyTemplateV2<CalguataInfo, CalguataInfo> {
	
	public LazyCalguataPrunePlanata(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CalguataInfo> translateRecordInfosHook(List<CalguataInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CalguataInfo> getInstanceOfActionHook(DeciTreeOption<CalguataInfo> option) {
		return new StdCalguataPrunePlanata(option);
	}
	
	
	
	@Override protected DeciResult<CalguataInfo> translateResultHook(DeciResult<CalguataInfo> result) {
		return result;
	}
}
