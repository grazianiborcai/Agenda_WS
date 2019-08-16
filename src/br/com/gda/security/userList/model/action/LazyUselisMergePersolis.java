package br.com.gda.security.userList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userList.info.UselisInfo;

public final class LazyUselisMergePersolis extends ActionLazyTemplate<UselisInfo, UselisInfo> {
	
	public LazyUselisMergePersolis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UselisInfo> translateRecordInfosHook(List<UselisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<UselisInfo> getInstanceOfActionHook(DeciTreeOption<UselisInfo> option) {
		return new StdUserMergePerson(option);
	}
	
	
	
	@Override protected DeciResult<UselisInfo> translateResultHook(DeciResult<UselisInfo> result) {
		return result;
	}
}
