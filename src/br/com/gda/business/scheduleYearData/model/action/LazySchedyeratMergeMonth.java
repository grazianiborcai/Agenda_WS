package br.com.gda.business.scheduleYearData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazySchedyeratMergeMonth extends ActionLazyTemplate<SchedyeratInfo, SchedyeratInfo> {
	
	public LazySchedyeratMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedyeratInfo> translateRecordInfosHook(List<SchedyeratInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedyeratInfo> getInstanceOfActionHook(DeciTreeOption<SchedyeratInfo> option) {
		return new StdSchedyeratMergeMonth(option);
	}
	
	
	
	@Override protected DeciResult<SchedyeratInfo> translateResultHook(DeciResult<SchedyeratInfo> result) {
		return result;
	}
}
