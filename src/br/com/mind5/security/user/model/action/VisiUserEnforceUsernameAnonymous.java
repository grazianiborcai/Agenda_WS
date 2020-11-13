package br.com.mind5.security.user.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserSetterUsernameAnonymous;

final class VisiUserEnforceUsernameAnonymous extends ActionVisitorTemplateEnforce<UserInfo> {
	
	public VisiUserEnforceUsernameAnonymous(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		InfoSetter<UserInfo> attrSetter = new UserSetterUsernameAnonymous();
		return attrSetter.setAttr(recordInfo);
	}
}
