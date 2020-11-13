package br.com.mind5.security.userPassword.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.RootUpswdInsert;

public final class LazyUpswdRootInsert extends ActionLazyTemplate<UpswdInfo, UpswdInfo> {
	
	public LazyUpswdRootInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UpswdInfo> translateRecordInfosHook(List<UpswdInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<UpswdInfo> getInstanceOfActionHook(DeciTreeOption<UpswdInfo> option) {
		return new RootUpswdInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<UpswdInfo> translateResultHook(DeciResult<UpswdInfo> result) {
		return result;
	}
}
