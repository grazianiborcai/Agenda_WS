package br.com.mind5.business.addressSearch.model.action;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.info.AddarchSetterCusAddressKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddarchVisiEnforceCusAddressKey extends ActionVisitorTemplateEnforce<AddarchInfo> {
	
	public AddarchVisiEnforceCusAddressKey(DeciTreeOption<AddarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected AddarchInfo enforceHook(AddarchInfo recordInfo) {
		InfoSetter<AddarchInfo> attrSetter = new AddarchSetterCusAddressKey();
		return attrSetter.setAttr(recordInfo);
	}
}
