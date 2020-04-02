package br.com.mind5.business.scheduleWeekData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedeekdatMergeWeekday extends ActionLazyTemplate<SchedeekdatInfo, SchedeekdatInfo> {
	
	public LazySchedeekdatMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedeekdatInfo> translateRecordInfosHook(List<SchedeekdatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedeekdatInfo> getInstanceOfActionHook(DeciTreeOption<SchedeekdatInfo> option) {
		return new StdSchedeekdatMergeWeekday(option);
	}
	
	
	
	@Override protected DeciResult<SchedeekdatInfo> translateResultHook(DeciResult<SchedeekdatInfo> result) {
		return result;
	}
}
