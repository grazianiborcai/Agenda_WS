package br.com.mind5.business.calendarCatalogueData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCalguataPrunePlanata extends ActionLazyTemplate<CalguataInfo, CalguataInfo> {
	
	public LazyCalguataPrunePlanata(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CalguataInfo> translateRecordInfosHook(List<CalguataInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<CalguataInfo> getInstanceOfActionHook(DeciTreeOption<CalguataInfo> option) {
		return new StdCalguataPrunePlanata(option);
	}
	
	
	
	@Override protected DeciResult<CalguataInfo> translateResultHook(DeciResult<CalguataInfo> result) {
		return result;
	}
}
