package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiAddressEnforceCreatedOn extends ActionVisitorTemplateEnforce<AddressInfo> {
	
	@Override protected AddressInfo enforceHook(AddressInfo recordInfo) {
		InfoSetter<AddressInfo> attrSetter = new AddressSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
