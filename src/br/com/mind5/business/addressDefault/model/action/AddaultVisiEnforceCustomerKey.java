package br.com.mind5.business.addressDefault.model.action;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.info.AddaultSetterCustomerKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddaultVisiEnforceCustomerKey extends ActionVisitorTemplateEnforce<AddaultInfo> {
	
	public AddaultVisiEnforceCustomerKey(DeciTreeOption<AddaultInfo> option) {
		super(option);
	}

	
	
	@Override protected AddaultInfo enforceHook(AddaultInfo recordInfo) {
		InfoSetter<AddaultInfo> attrSetter = new AddaultSetterCustomerKey();
		return attrSetter.setAttr(recordInfo);
	}
}
