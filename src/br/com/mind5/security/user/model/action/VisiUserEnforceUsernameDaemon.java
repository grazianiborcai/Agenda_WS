package br.com.mind5.security.user.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserSetterUsernameDaemon;

final class VisiUserEnforceUsernameDaemon extends ActionVisitorTemplateEnforceV2<UserInfo> {
	
	public VisiUserEnforceUsernameDaemon(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		InfoSetter<UserInfo> attrSetter = new UserSetterUsernameDaemon();
		return attrSetter.setAttr(recordInfo);
	}
}
