package br.com.mind5.business.calendarTimeStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.model.decisionTree.NodeCalimoreSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCalimoreNodeSelect extends ActionLazyTemplate<CalimoreInfo, CalimoreInfo> {

	public LazyCalimoreNodeSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CalimoreInfo> translateRecordInfosHook(List<CalimoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<CalimoreInfo> getInstanceOfActionHook(DeciTreeOption<CalimoreInfo> option) {
		return new NodeCalimoreSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CalimoreInfo> translateResultHook(DeciResult<CalimoreInfo> result) {
		return result;
	}
}
