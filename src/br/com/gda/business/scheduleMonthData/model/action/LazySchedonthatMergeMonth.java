package br.com.gda.business.scheduleMonthData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazySchedonthatMergeMonth extends ActionLazyTemplate<SchedonthatInfo, SchedonthatInfo> {
	
	public LazySchedonthatMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedonthatInfo> translateRecordInfosHook(List<SchedonthatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedonthatInfo> getInstanceOfActionHook(DeciTreeOption<SchedonthatInfo> option) {
		return new StdSchedonthatMergeMonth(option);
	}
	
	
	
	@Override protected DeciResult<SchedonthatInfo> translateResultHook(DeciResult<SchedonthatInfo> result) {
		return result;
	}
}
