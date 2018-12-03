package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyUserUpdatePerson extends ActionLazyTemplate<UserInfo, UserInfo> {
	
	public LazyUserUpdatePerson(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UserInfo> translateRecordInfosHook(List<UserInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UserInfo> getInstanceOfActionHook(DeciTreeOption<UserInfo> option) {
		return new StdUserUpdatePerson(option);
	}
	
	
	
	@Override protected DeciResult<UserInfo> translateResultHook(DeciResult<UserInfo> result) {
		return result;
	}
}
