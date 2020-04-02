package br.com.mind5.security.username.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;

public final class LazyUsernameMergeAuthGrRole extends ActionLazyTemplate<UsernameInfo, UsernameInfo> {
	
	public LazyUsernameMergeAuthGrRole(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UsernameInfo> translateRecordInfosHook(List<UsernameInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<UsernameInfo> getInstanceOfActionHook(DeciTreeOption<UsernameInfo> option) {
		return new StdUsernameMergeAuthGrRole(option);
	}
	
	
	
	@Override protected DeciResult<UsernameInfo> translateResultHook(DeciResult<UsernameInfo> result) {
		return result;
	}
}
