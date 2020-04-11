package br.com.mind5.business.scheduleYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedyearMergeStolis extends ActionLazyTemplateV1<SchedyearInfo, SchedyearInfo> {
	
	public LazySchedyearMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedyearInfo> translateRecordInfosHook(List<SchedyearInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedyearInfo> getInstanceOfActionHook(DeciTreeOption<SchedyearInfo> option) {
		return new StdSchedyearMergeStolis(option);
	}
	
	
	
	@Override protected DeciResult<SchedyearInfo> translateResultHook(DeciResult<SchedyearInfo> result) {
		return result;
	}
}
