package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

public final class LazyUserMergePersonCus extends ActionLazyTemplate<UserInfo, UserInfo> {
	
	public LazyUserMergePersonCus(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UserInfo> translateRecordInfosHook(List<UserInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UserInfo> getInstanceOfActionHook(DeciTreeOption<UserInfo> option) {
		return new StdUserMergePersonCus(option);
	}
	
	
	
	@Override protected DeciResult<UserInfo> translateResultHook(DeciResult<UserInfo> result) {
		return result;
	}
}
