package br.com.mind5.business.scheduleMonthData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedonthatMergeMonth extends ActionLazyTemplateV2<SchedonthatInfo, SchedonthatInfo> {
	
	public LazySchedonthatMergeMonth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedonthatInfo> translateRecordInfosHook(List<SchedonthatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedonthatInfo> getInstanceOfActionHook(DeciTreeOption<SchedonthatInfo> option) {
		return new StdSchedonthatMergeMonth(option);
	}
	
	
	
	@Override protected DeciResult<SchedonthatInfo> translateResultHook(DeciResult<SchedonthatInfo> result) {
		return result;
	}
}
