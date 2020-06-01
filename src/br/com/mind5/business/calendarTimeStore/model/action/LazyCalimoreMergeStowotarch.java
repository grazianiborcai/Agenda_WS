package br.com.mind5.business.calendarTimeStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCalimoreMergeStowotarch extends ActionLazyTemplateV2<CalimoreInfo, CalimoreInfo> {

	public LazyCalimoreMergeStowotarch(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CalimoreInfo> translateRecordInfosHook(List<CalimoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CalimoreInfo> getInstanceOfActionHook(DeciTreeOption<CalimoreInfo> option) {
		return new StdCalimoreMergeStowotarch(option);
	}
	
	
	
	@Override protected DeciResult<CalimoreInfo> translateResultHook(DeciResult<CalimoreInfo> result) {
		return result;
	}
}
