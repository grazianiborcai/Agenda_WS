package br.com.gda.message.email.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.message.email.info.EmailSetterWelcome;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmailEnforceWelcome extends ActionVisitorTemplateEnforce<EmailInfo> {
	
	@Override protected EmailInfo enforceHook(EmailInfo recordInfo) {
		InfoSetter<EmailInfo> attrSetter = new EmailSetterWelcome();
		return attrSetter.setAttr(recordInfo);
	}
}
