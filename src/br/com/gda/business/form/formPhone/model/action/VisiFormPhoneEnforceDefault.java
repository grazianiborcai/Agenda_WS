package br.com.gda.business.form.formPhone.model.action;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.form.formPhone.info.FormPhoneSetterDefault;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFormPhoneEnforceDefault extends ActionVisitorTemplateEnforce<FormPhoneInfo> {
	
	@Override protected FormPhoneInfo enforceHook(FormPhoneInfo recordInfo) {
		FormPhoneSetterDefault attrSetter = new FormPhoneSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
