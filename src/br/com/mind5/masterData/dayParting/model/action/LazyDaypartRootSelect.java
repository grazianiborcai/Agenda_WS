package br.com.mind5.masterData.dayParting.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.model.decisionTree.RootDaypartSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyDaypartRootSelect extends ActionLazyTemplate<DaypartInfo, DaypartInfo> {

	public LazyDaypartRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<DaypartInfo> translateRecordInfosHook(List<DaypartInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<DaypartInfo> getInstanceOfActionHook(DeciTreeOption<DaypartInfo> option) {
		return new RootDaypartSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<DaypartInfo> translateResultHook(DeciResult<DaypartInfo> result) {
		return result;
	}
}
