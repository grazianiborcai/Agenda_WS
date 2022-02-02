package br.com.mind5.security.user.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

public final class StdUserEnforceCreatedBy extends ActionStdTemplate<UserInfo> {

	public StdUserEnforceCreatedBy(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UserInfo> buildVisitorHook(DeciTreeOption<UserInfo> option) {
		return new VisiUserEnforceCreatedBy(option);
	}
}
