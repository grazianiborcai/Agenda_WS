package br.com.mind5.message.email.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmailEnforcePasswordChange extends ActionLazyTemplate<EmailInfo, EmailInfo> {

	public LazyEmailEnforcePasswordChange(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmailInfo> translateRecordInfosHook(List<EmailInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmailInfo> getInstanceOfActionHook(DeciTreeOption<EmailInfo> option) {
		return new StdEmailEnforcePasswordChange(option);
	}
	
	
	
	@Override protected DeciResult<EmailInfo> translateResultHook(DeciResult<EmailInfo> result) {
		return result;
	}
}
