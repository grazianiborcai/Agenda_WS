package br.com.mind5.security.userSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.decisionTree.RootUserarchSelectAuth;

public final class LazyUserarchRootSelectAuth extends ActionLazyTemplate<UserarchInfo, UserarchInfo> {
	
	public LazyUserarchRootSelectAuth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UserarchInfo> translateRecordInfosHook(List<UserarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UserarchInfo> getInstanceOfActionHook(DeciTreeOption<UserarchInfo> option) {
		return new RootUserarchSelectAuth(option).toAction();
	}
	
	
	
	@Override protected DeciResult<UserarchInfo> translateResultHook(DeciResult<UserarchInfo> result) {
		return result;
	}
}
