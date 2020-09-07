package br.com.mind5.business.calendarCatalogue.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCalgueEnforceAvailable extends ActionLazyTemplateV2<CalgueInfo, CalgueInfo> {

	public LazyCalgueEnforceAvailable(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CalgueInfo> translateRecordInfosHook(List<CalgueInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CalgueInfo> getInstanceOfActionHook(DeciTreeOption<CalgueInfo> option) {
		return new StdCalgueEnforceAvailable(option);
	}
	
	
	
	@Override protected DeciResult<CalgueInfo> translateResultHook(DeciResult<CalgueInfo> result) {
		return result;
	}
}
