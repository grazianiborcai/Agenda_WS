package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressEnforceLChanged extends ActionVisitorTemplateEnforceV2<AddressInfo> {
	
	public VisiAddressEnforceLChanged(DeciTreeOption<AddressInfo> option) {
		super(option);
	}

	
	
	@Override protected AddressInfo enforceHook(AddressInfo recordInfo) {
		InfoSetter<AddressInfo> attrSetter = new AddressSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
