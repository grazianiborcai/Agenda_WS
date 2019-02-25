package br.com.gda.security.username.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.username.info.UsernameInfo;

public final class LazyUsernameMergeAuthGrRole extends ActionLazyTemplate<UsernameInfo, UsernameInfo> {
	
	public LazyUsernameMergeAuthGrRole(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UsernameInfo> translateRecordInfosHook(List<UsernameInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UsernameInfo> getInstanceOfActionHook(DeciTreeOption<UsernameInfo> option) {
		return new StdUsernameMergeAuthGrRole(option);
	}
	
	
	
	@Override protected DeciResult<UsernameInfo> translateResultHook(DeciResult<UsernameInfo> result) {
		return result;
	}
}
