package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressSetterDefaultOff;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddressVisiEnforceDefaultOff extends ActionVisitorTemplateEnforce<AddressInfo> {
	
	public AddressVisiEnforceDefaultOff(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected AddressInfo enforceHook(AddressInfo recordInfo) {
		InfoSetter<AddressInfo> attrSetter = new AddressSetterDefaultOff();
		return attrSetter.setAttr(recordInfo);
	}
}
