package br.com.mind5.business.personUser_.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
