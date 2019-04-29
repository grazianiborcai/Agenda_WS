package br.com.gda.business.personUser_.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.personUser_.info.PersonUserInfo;
import br.com.gda.business.personUser_.model.decisionTree.NodePersonUserEmail;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPersonUserNodeEmail extends ActionLazyTemplate<PersonUserInfo, PersonUserInfo> {
	
	public LazyPersonUserNodeEmail(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersonUserInfo> translateRecordInfosHook(List<PersonUserInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PersonUserInfo> getInstanceOfActionHook(DeciTreeOption<PersonUserInfo> option) {
		return new NodePersonUserEmail(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PersonUserInfo> translateResultHook(DeciResult<PersonUserInfo> result) {
		return result;
	}
}
