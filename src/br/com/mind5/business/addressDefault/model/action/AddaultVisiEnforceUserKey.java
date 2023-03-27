package br.com.mind5.business.addressDefault.model.action;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.info.AddaultSetterUserKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddaultVisiEnforceUserKey extends ActionVisitorTemplateEnforce<AddaultInfo> {
	
	public AddaultVisiEnforceUserKey(DeciTreeOption<AddaultInfo> option) {
		super(option);
	}

	
	
	@Override protected AddaultInfo enforceHook(AddaultInfo recordInfo) {
		InfoSetter<AddaultInfo> attrSetter = new AddaultSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
