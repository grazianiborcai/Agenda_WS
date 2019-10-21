package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiAddressEnforceCreatedBy extends ActionVisitorTemplateEnforce<AddressInfo> {
	
	@Override protected AddressInfo enforceHook(AddressInfo recordInfo) {
		InfoSetter<AddressInfo> attrSetter = new AddressSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
