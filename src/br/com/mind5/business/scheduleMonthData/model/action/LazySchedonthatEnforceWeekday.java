package br.com.mind5.business.scheduleMonthData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedonthatEnforceWeekday extends ActionLazyTemplate<SchedonthatInfo, SchedonthatInfo> {
	
	public LazySchedonthatEnforceWeekday(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedonthatInfo> translateRecordInfosHook(List<SchedonthatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedonthatInfo> getInstanceOfActionHook(DeciTreeOption<SchedonthatInfo> option) {
		return new StdSchedonthatEnforceWeekday(option);
	}
	
	
	
	@Override protected DeciResult<SchedonthatInfo> translateResultHook(DeciResult<SchedonthatInfo> result) {
		return result;
	}
}
