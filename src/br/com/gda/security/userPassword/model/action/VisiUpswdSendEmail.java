package br.com.gda.security.userPassword.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.message.email.info.EmailCopier;
import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.message.email.model.decisionTree.RootEmailWelcome;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userPassword.info.UpswdInfo;

final class VisiUpswdSendEmail extends ActionVisitorTemplateAction<UpswdInfo, EmailInfo> {
	public VisiUpswdSendEmail(Connection conn, String schemaName) {
		super(conn, schemaName, UpswdInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmailInfo> getActionHook(DeciTreeOption<EmailInfo> option) {
		return new RootEmailWelcome(option).toAction();
	}
	
	
	
	@Override protected List<EmailInfo> toActionClassHook(List<UpswdInfo> recordInfos) {
		return EmailCopier.copyFromUpswd(recordInfos);
	}
	
	
	
	@Override protected List<UpswdInfo> toBaseClassHook(List<UpswdInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}
