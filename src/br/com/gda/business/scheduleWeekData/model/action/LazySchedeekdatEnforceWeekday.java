package br.com.gda.business.scheduleWeekData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazySchedeekdatEnforceWeekday extends ActionLazyTemplate<SchedeekdatInfo, SchedeekdatInfo> {
	
	public LazySchedeekdatEnforceWeekday(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedeekdatInfo> translateRecordInfosHook(List<SchedeekdatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedeekdatInfo> getInstanceOfActionHook(DeciTreeOption<SchedeekdatInfo> option) {
		return new StdSchedeekdatEnforceWeekday(option);
	}
	
	
	
	@Override protected DeciResult<SchedeekdatInfo> translateResultHook(DeciResult<SchedeekdatInfo> result) {
		return result;
	}
}
