package br.com.mind5.business.scheduleDay.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedayMergeSchedatus extends ActionLazyTemplate<SchedayInfo, SchedayInfo> {
	
	public LazySchedayMergeSchedatus(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedayInfo> translateRecordInfosHook(List<SchedayInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedayInfo> getInstanceOfActionHook(DeciTreeOption<SchedayInfo> option) {
		return new StdSchedayMergeSchedatus(option);
	}
	
	
	
	@Override protected DeciResult<SchedayInfo> translateResultHook(DeciResult<SchedayInfo> result) {
		return result;
	}
}
