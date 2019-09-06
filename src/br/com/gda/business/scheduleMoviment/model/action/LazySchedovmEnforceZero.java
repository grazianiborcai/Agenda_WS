package br.com.gda.business.scheduleMoviment.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleMoviment.info.SchedovmInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazySchedovmEnforceZero extends ActionLazyTemplate<SchedovmInfo, SchedovmInfo> {
	
	public LazySchedovmEnforceZero(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedovmInfo> translateRecordInfosHook(List<SchedovmInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedovmInfo> getInstanceOfActionHook(DeciTreeOption<SchedovmInfo> option) {
		return new StdSchedovmEnforceZero(option);
	}
	
	
	
	@Override protected DeciResult<SchedovmInfo> translateResultHook(DeciResult<SchedovmInfo> result) {
		return result;
	}
}
