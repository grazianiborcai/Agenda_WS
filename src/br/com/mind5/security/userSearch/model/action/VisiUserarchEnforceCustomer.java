package br.com.mind5.security.userSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.info.UserarchSetterCustomer;

final class VisiUserarchEnforceCustomer extends ActionVisitorTemplateEnforce<UserarchInfo> {
	
	public VisiUserarchEnforceCustomer(DeciTreeOption<UserarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected UserarchInfo enforceHook(UserarchInfo recordInfo) {
		InfoSetter<UserarchInfo> attrSetter = new UserarchSetterCustomer();
		return attrSetter.setAttr(recordInfo);
	}
}
