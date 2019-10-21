package br.com.mind5.message.email.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.info.EmailSetterEmabody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiEmailEnforceEmabody extends ActionVisitorTemplateEnforce<EmailInfo> {
	
	@Override protected EmailInfo enforceHook(EmailInfo recordInfo) {
		InfoSetter<EmailInfo> attrSetter = new EmailSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
