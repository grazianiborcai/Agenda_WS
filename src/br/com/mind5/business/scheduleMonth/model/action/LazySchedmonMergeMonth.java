package br.com.mind5.business.scheduleMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedmonMergeMonth extends ActionLazyTemplateV2<SchedmonInfo, SchedmonInfo> {
	
	public LazySchedmonMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedmonInfo> translateRecordInfosHook(List<SchedmonInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedmonInfo> getInstanceOfActionHook(DeciTreeOption<SchedmonInfo> option) {
		return new StdSchedmonMergeMonth(option);
	}
	
	
	
	@Override protected DeciResult<SchedmonInfo> translateResultHook(DeciResult<SchedmonInfo> result) {
		return result;
	}
}
