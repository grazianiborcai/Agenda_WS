package br.com.mind5.masterData.weekday.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyWeekdayRootSelect extends ActionLazyTemplate<WeekdayInfo, WeekdayInfo> {

	public LazyWeekdayRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<WeekdayInfo> translateRecordInfosHook(List<WeekdayInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<WeekdayInfo> getInstanceOfActionHook(DeciTreeOption<WeekdayInfo> option) {
		return new RootWeekdaySelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<WeekdayInfo> translateResultHook(DeciResult<WeekdayInfo> result) {
		return result;
	}
}
