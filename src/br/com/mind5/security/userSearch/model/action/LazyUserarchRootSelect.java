package br.com.mind5.security.userSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.decisionTree.RootUserarchSelect;

public final class LazyUserarchRootSelect extends ActionLazyTemplate<UserarchInfo, UserarchInfo> {
	
	public LazyUserarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UserarchInfo> translateRecordInfosHook(List<UserarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<UserarchInfo> getInstanceOfActionHook(DeciTreeOption<UserarchInfo> option) {
		return new RootUserarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<UserarchInfo> translateResultHook(DeciResult<UserarchInfo> result) {
		return result;
	}
}
