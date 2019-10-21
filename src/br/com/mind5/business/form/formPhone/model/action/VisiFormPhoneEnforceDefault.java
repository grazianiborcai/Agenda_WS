package br.com.mind5.business.form.formPhone.model.action;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.business.form.formPhone.info.FormPhoneSetterDefault;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiFormPhoneEnforceDefault extends ActionVisitorTemplateEnforce<FormPhoneInfo> {
	
	@Override protected FormPhoneInfo enforceHook(FormPhoneInfo recordInfo) {
		FormPhoneSetterDefault attrSetter = new FormPhoneSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
