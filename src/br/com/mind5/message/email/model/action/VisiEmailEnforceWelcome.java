package br.com.mind5.message.email.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.info.EmailSetterWelcome;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmailEnforceWelcome extends ActionVisitorTemplateEnforceV2<EmailInfo> {
	
	public VisiEmailEnforceWelcome(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmailInfo enforceHook(EmailInfo recordInfo) {
		InfoSetter<EmailInfo> attrSetter = new EmailSetterWelcome();
		return attrSetter.setAttr(recordInfo);
	}
}
