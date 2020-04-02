package br.com.mind5.business.scheduleMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedmonMergeEmplis extends ActionLazyTemplate<SchedmonInfo, SchedmonInfo> {
	
	public LazySchedmonMergeEmplis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedmonInfo> translateRecordInfosHook(List<SchedmonInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedmonInfo> getInstanceOfActionHook(DeciTreeOption<SchedmonInfo> option) {
		return new StdSchedmonMergeEmplis(option);
	}
	
	
	
	@Override protected DeciResult<SchedmonInfo> translateResultHook(DeciResult<SchedmonInfo> result) {
		return result;
	}
}
