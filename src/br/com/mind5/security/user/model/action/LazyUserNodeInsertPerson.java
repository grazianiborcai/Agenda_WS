package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.NodeUserInsertPerson;

public final class LazyUserNodeInsertPerson extends ActionLazyTemplateV1<UserInfo, UserInfo> {
	
	public LazyUserNodeInsertPerson(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UserInfo> translateRecordInfosHook(List<UserInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<UserInfo> getInstanceOfActionHook(DeciTreeOption<UserInfo> option) {
		return new NodeUserInsertPerson(option).toAction();
	}
	
	
	
	@Override protected DeciResult<UserInfo> translateResultHook(DeciResult<UserInfo> result) {
		return result;
	}
}
