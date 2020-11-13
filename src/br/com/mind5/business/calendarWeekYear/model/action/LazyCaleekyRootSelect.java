package br.com.mind5.business.calendarWeekYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.decisionTree.RootCaleekySelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCaleekyRootSelect extends ActionLazyTemplate<CaleekyInfo, CaleekyInfo> {
	
	public LazyCaleekyRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CaleekyInfo> translateRecordInfosHook(List<CaleekyInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CaleekyInfo> getInstanceOfActionHook(DeciTreeOption<CaleekyInfo> option) {
		return new RootCaleekySelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CaleekyInfo> translateResultHook(DeciResult<CaleekyInfo> result) {
		return result;
	}
}
