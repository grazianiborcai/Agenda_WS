package br.com.mind5.authorization.scheduleAuthorization.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySchedauthDaoSelect extends ActionLazyTemplate<SchedauthInfo, SchedauthInfo> {
	
	public LazySchedauthDaoSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SchedauthInfo> translateRecordInfosHook(List<SchedauthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SchedauthInfo> getInstanceOfActionHook(DeciTreeOption<SchedauthInfo> option) {
		return new StdSchedauthDaoSelect(option);
	}
	
	
	
	@Override protected DeciResult<SchedauthInfo> translateResultHook(DeciResult<SchedauthInfo> result) {
		return result;
	}
}
