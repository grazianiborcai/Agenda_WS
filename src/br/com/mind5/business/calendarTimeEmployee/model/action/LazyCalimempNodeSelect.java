package br.com.mind5.business.calendarTimeEmployee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.model.decisionTree.NodeCalimempSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCalimempNodeSelect extends ActionLazyTemplate<CalimempInfo, CalimempInfo> {

	public LazyCalimempNodeSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CalimempInfo> translateRecordInfosHook(List<CalimempInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CalimempInfo> getInstanceOfActionHook(DeciTreeOption<CalimempInfo> option) {
		return new NodeCalimempSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CalimempInfo> translateResultHook(DeciResult<CalimempInfo> result) {
		return result;
	}
}
