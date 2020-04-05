package br.com.mind5.business.form.formPhone.model.action;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.business.form.formPhone.info.FormPhoneSetterDefault;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiFormPhoneEnforceDefault extends ActionVisitorTemplateEnforceV1<FormPhoneInfo> {
	
	@Override protected FormPhoneInfo enforceHook(FormPhoneInfo recordInfo) {
		FormPhoneSetterDefault attrSetter = new FormPhoneSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
