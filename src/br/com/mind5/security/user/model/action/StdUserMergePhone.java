package br.com.mind5.security.user.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

public final class StdUserMergePhone extends ActionStdTemplateV2<UserInfo> {

	public StdUserMergePhone(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<UserInfo> buildVisitorHook(DeciTreeOption<UserInfo> option) {
		return new VisiUserMergePhone(option);
	}
}
