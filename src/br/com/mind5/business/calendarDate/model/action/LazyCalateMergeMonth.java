package br.com.mind5.business.calendarDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCalateMergeMonth extends ActionLazyTemplateV2<CalateInfo, CalateInfo> {
	
	public LazyCalateMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CalateInfo> translateRecordInfosHook(List<CalateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CalateInfo> getInstanceOfActionHook(DeciTreeOption<CalateInfo> option) {
		return new StdCalateMergeMonth(option);
	}
	
	
	
	@Override protected DeciResult<CalateInfo> translateResultHook(DeciResult<CalateInfo> result) {
		return result;
	}
}
