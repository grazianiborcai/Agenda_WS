package br.com.gda.business.form.model.action;

import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.business.form.info.AddressFormSetterDefault;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiAddressFormEnforceDefault extends ActionVisitorTemplateEnforce<AddressFormInfo> {
	
	@Override protected AddressFormInfo enforceHook(AddressFormInfo recordInfo) {
		AddressFormSetterDefault attrSetter = new AddressFormSetterDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
