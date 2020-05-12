package br.com.mind5.message.email.model.action;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmailSendMessage extends ActionStdTemplateV2<EmailInfo> {

	public StdEmailSendMessage(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmailInfo> buildVisitorHook(DeciTreeOption<EmailInfo> option) {
		return new VisiEmailSendMessage(option);
	}
}
