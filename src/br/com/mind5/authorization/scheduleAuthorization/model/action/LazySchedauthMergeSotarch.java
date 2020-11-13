package br.com.mind5.authorization.scheduleAuthorization.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedauthMergeSotarch extends ActionLazyTemplate<SchedauthInfo, SchedauthInfo> {
	
	public LazySchedauthMergeSotarch(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedauthInfo> translateRecordInfosHook(List<SchedauthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<SchedauthInfo> getInstanceOfActionHook(DeciTreeOption<SchedauthInfo> option) {
		return new StdSchedauthMergeSotarch(option);
	}
	
	
	
	@Override protected DeciResult<SchedauthInfo> translateResultHook(DeciResult<SchedauthInfo> result) {
		return result;
	}
}
