package br.com.mind5.business.calendarWeekYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCaleekyMergePrevious extends ActionLazyTemplate<CaleekyInfo, CaleekyInfo> {
	
	public LazyCaleekyMergePrevious(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CaleekyInfo> translateRecordInfosHook(List<CaleekyInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<CaleekyInfo> getInstanceOfActionHook(DeciTreeOption<CaleekyInfo> option) {
		return new StdCaleekyMergePrevious(option);
	}
	
	
	
	@Override protected DeciResult<CaleekyInfo> translateResultHook(DeciResult<CaleekyInfo> result) {
		return result;
	}
}
