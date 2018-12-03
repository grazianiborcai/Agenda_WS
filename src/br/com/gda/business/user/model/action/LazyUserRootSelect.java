package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.decisionTree.RootUserSelect;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyUserRootSelect extends ActionLazyTemplate<UserInfo, UserInfo> {
	
	public LazyUserRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UserInfo> translateRecordInfosHook(List<UserInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UserInfo> getInstanceOfActionHook(DeciTreeOption<UserInfo> option) {
		return new RootUserSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<UserInfo> translateResultHook(DeciResult<UserInfo> result) {
		return result;
	}
}
