package br.com.gda.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazySchedineEnforceYear extends ActionLazyTemplate<SchedineInfo, SchedineInfo> {
	
	public LazySchedineEnforceYear(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedineInfo> translateRecordInfosHook(List<SchedineInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedineInfo> getInstanceOfActionHook(DeciTreeOption<SchedineInfo> option) {
		return new StdSchedineEnforceYear(option);
	}
	
	
	
	@Override protected DeciResult<SchedineInfo> translateResultHook(DeciResult<SchedineInfo> result) {
		return result;
	}
}
