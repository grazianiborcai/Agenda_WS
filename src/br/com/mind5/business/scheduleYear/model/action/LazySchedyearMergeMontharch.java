package br.com.mind5.business.scheduleYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedyearMergeMontharch extends ActionLazyTemplate<SchedyearInfo, SchedyearInfo> {
	
	public LazySchedyearMergeMontharch(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedyearInfo> translateRecordInfosHook(List<SchedyearInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedyearInfo> getInstanceOfActionHook(DeciTreeOption<SchedyearInfo> option) {
		return new StdSchedyearMergeMontharch(option);
	}
	
	
	
	@Override protected DeciResult<SchedyearInfo> translateResultHook(DeciResult<SchedyearInfo> result) {
		return result;
	}
}
