package br.com.mind5.security.user.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

public final class StdUserEnforceAuthStore extends ActionStdTemplateV2<UserInfo> {

	public StdUserEnforceAuthStore(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<UserInfo> buildVisitorHook(DeciTreeOption<UserInfo> option) {
		return new VisiUserEnforceAuthStore(option);
	}
}
