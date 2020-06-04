package br.com.mind5.business.calendarWeekYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.decisionTree.RootCaleekySelect;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCaleekyRootSelect extends ActionLazyTemplateV2<CaleekyInfo, CaleekyInfo> {
	
	public LazyCaleekyRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CaleekyInfo> translateRecordInfosHook(List<CaleekyInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CaleekyInfo> getInstanceOfActionHook(DeciTreeOption<CaleekyInfo> option) {
		return new RootCaleekySelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CaleekyInfo> translateResultHook(DeciResult<CaleekyInfo> result) {
		return result;
	}
}
