package br.com.gda.message.email.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.message.email.info.EmailSetterEmabody;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmailEnforceEmabody extends ActionVisitorTemplateEnforce<EmailInfo> {
	
	@Override protected EmailInfo enforceHook(EmailInfo recordInfo) {
		InfoSetter<EmailInfo> attrSetter = new EmailSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
