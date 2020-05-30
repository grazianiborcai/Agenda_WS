package br.com.mind5.business.scheduleDay.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedayMergeCalate extends ActionLazyTemplateV2<SchedayInfo, SchedayInfo> {
	
	public LazySchedayMergeCalate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedayInfo> translateRecordInfosHook(List<SchedayInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedayInfo> getInstanceOfActionHook(DeciTreeOption<SchedayInfo> option) {
		return new StdSchedayMergeCalate(option);
	}
	
	
	
	@Override protected DeciResult<SchedayInfo> translateResultHook(DeciResult<SchedayInfo> result) {
		return result;
	}
}
