package br.com.mind5.security.userSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class StdUserarchEnforceManager extends ActionStdTemplate<UserarchInfo> {

	public StdUserarchEnforceManager(DeciTreeOption<UserarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UserarchInfo> buildVisitorHook(DeciTreeOption<UserarchInfo> option) {
		return new VisiUserarchEnforceManager(option);
	}
}
