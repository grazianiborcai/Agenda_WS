package br.com.gda.business.personUser.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPersonUserMergeUser extends ActionLazyTemplate<PersonUserInfo, PersonUserInfo> {
	
	public LazyPersonUserMergeUser(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PersonUserInfo> translateRecordInfosHook(List<PersonUserInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PersonUserInfo> getInstanceOfActionHook(DeciTreeOption<PersonUserInfo> option) {
		return new StdPersonUserMergeUser(option);
	}
	
	
	
	@Override protected DeciResult<PersonUserInfo> translateResultHook(DeciResult<PersonUserInfo> result) {
		return result;
	}
}
