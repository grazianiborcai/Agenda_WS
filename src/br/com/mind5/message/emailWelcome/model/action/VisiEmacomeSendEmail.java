package br.com.mind5.message.emailWelcome.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.email.info.EmailCopier;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.decisionTree.RootEmailWelcome;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmacomeSendEmail extends ActionVisitorTemplateAction<EmacomeInfo, EmailInfo> {
	public VisiEmacomeSendEmail(Connection conn, String schemaName) {
		super(conn, schemaName, EmacomeInfo.class, EmailInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmailInfo> getActionHook(DeciTreeOption<EmailInfo> option) {
		return new RootEmailWelcome(option).toAction();
	}
	
	
	
	@Override protected List<EmailInfo> toActionClassHook(List<EmacomeInfo> recordInfos) {
		return EmailCopier.copyFromEmacome(recordInfos);
	}
	
	
	
	@Override protected List<EmacomeInfo> toBaseClassHook(List<EmacomeInfo> baseInfos, List<EmailInfo> results) {
		return baseInfos;
	}
}