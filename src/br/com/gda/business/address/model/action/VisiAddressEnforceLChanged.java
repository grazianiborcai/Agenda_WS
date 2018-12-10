package br.com.gda.business.address.model.action;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.info.AddressSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiAddressEnforceLChanged extends ActionVisitorTemplateEnforce<AddressInfo> {
	
	@Override protected AddressInfo enforceHook(AddressInfo recordInfo) {
		InfoSetter<AddressInfo> attrSetter = new AddressSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
