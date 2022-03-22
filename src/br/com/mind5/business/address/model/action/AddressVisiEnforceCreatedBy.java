package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddressVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<AddressInfo> {
	
	public AddressVisiEnforceCreatedBy(DeciTreeOption<AddressInfo> option) {
		super(option);
	}

	
	
	@Override protected AddressInfo enforceHook(AddressInfo recordInfo) {
		InfoSetter<AddressInfo> attrSetter = new AddressSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
