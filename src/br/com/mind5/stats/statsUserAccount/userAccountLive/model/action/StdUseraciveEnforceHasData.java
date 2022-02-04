package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;

public final class StdUseraciveEnforceHasData extends ActionStdTemplate<UseraciveInfo> {

	public StdUseraciveEnforceHasData(DeciTreeOption<UseraciveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UseraciveInfo> buildVisitorHook(DeciTreeOption<UseraciveInfo> option) {
		return new VisiUseraciveEnforceHasData(option);
	}
}
