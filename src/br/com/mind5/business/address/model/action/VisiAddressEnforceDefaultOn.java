package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressSetterDefaultOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressEnforceDefaultOn extends ActionVisitorTemplateEnforceV2<AddressInfo> {
	
	public VisiAddressEnforceDefaultOn(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected AddressInfo enforceHook(AddressInfo recordInfo) {
		InfoSetter<AddressInfo> attrSetter = new AddressSetterDefaultOn();
		return attrSetter.setAttr(recordInfo);
	}
}
