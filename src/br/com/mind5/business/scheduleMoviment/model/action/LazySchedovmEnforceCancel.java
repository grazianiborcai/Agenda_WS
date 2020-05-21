package br.com.mind5.business.scheduleMoviment.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedovmEnforceCancel extends ActionLazyTemplateV2<SchedovmInfo, SchedovmInfo> {
	
	public LazySchedovmEnforceCancel(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedovmInfo> translateRecordInfosHook(List<SchedovmInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SchedovmInfo> getInstanceOfActionHook(DeciTreeOption<SchedovmInfo> option) {
		return new StdSchedovmEnforceCancel(option);
	}
	
	
	
	@Override protected DeciResult<SchedovmInfo> translateResultHook(DeciResult<SchedovmInfo> result) {
		return result;
	}
}
