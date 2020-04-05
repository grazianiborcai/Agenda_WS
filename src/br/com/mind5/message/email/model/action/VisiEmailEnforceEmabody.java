package br.com.mind5.message.email.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.info.EmailSetterEmabody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiEmailEnforceEmabody extends ActionVisitorTemplateEnforceV1<EmailInfo> {
	
	@Override protected EmailInfo enforceHook(EmailInfo recordInfo) {
		InfoSetter<EmailInfo> attrSetter = new EmailSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
