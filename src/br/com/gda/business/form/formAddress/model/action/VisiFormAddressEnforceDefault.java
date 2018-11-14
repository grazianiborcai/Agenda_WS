package br.com.gda.business.form.formAddress.model.action;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.form.formAddress.info.FormAddressSetterDefault;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiFormAddressEnforceDefault extends ActionVisitorTemplateEnforce<FormAddressInfo> {
	
	@Override protected FormAddressInfo enforceHook(FormAddressInfo recordInfo) {
		FormAddressSetterDefault attrSetter = new FormAddressSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
