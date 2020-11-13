package br.com.mind5.security.username.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;

public final class LazyUsernameMergeAuthgrole extends ActionLazyTemplate<UsernameInfo, UsernameInfo> {
	
	public LazyUsernameMergeAuthgrole(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UsernameInfo> translateRecordInfosHook(List<UsernameInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<UsernameInfo> getInstanceOfActionHook(DeciTreeOption<UsernameInfo> option) {
		return new StdUsernameMergeAuthgrole(option);
	}
	
	
	
	@Override protected DeciResult<UsernameInfo> translateResultHook(DeciResult<UsernameInfo> result) {
		return result;
	}
}
