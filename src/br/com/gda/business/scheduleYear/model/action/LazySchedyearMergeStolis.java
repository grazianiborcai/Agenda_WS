package br.com.gda.business.scheduleYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleYear.info.SchedyearInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazySchedyearMergeStolis extends ActionLazyTemplate<SchedyearInfo, SchedyearInfo> {
	
	public LazySchedyearMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedyearInfo> translateRecordInfosHook(List<SchedyearInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedyearInfo> getInstanceOfActionHook(DeciTreeOption<SchedyearInfo> option) {
		return new StdSchedyearMergeStolis(option);
	}
	
	
	
	@Override protected DeciResult<SchedyearInfo> translateResultHook(DeciResult<SchedyearInfo> result) {
		return result;
	}
}
