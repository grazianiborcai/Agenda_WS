package br.com.mind5.business.form.formAddress.model.action;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.business.form.formAddress.info.FormAddressSetterDefault;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiFormAddressEnforceDefault extends ActionVisitorTemplateEnforce<FormAddressInfo> {
	
	@Override protected FormAddressInfo enforceHook(FormAddressInfo recordInfo) {
		FormAddressSetterDefault attrSetter = new FormAddressSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
