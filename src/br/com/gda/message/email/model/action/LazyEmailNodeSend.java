package br.com.gda.message.email.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.message.email.model.decisionTree.NodeEmailSend;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmailNodeSend extends ActionLazyTemplate<EmailInfo, EmailInfo> {

	public LazyEmailNodeSend(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmailInfo> translateRecordInfosHook(List<EmailInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmailInfo> getInstanceOfActionHook(DeciTreeOption<EmailInfo> option) {
		return new NodeEmailSend(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmailInfo> translateResultHook(DeciResult<EmailInfo> result) {
		return result;
	}
}
