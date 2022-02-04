package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;

public final class StdSuseraciveEnforceHasData extends ActionStdTemplate<SuseraciveInfo> {

	public StdSuseraciveEnforceHasData(DeciTreeOption<SuseraciveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SuseraciveInfo> buildVisitorHook(DeciTreeOption<SuseraciveInfo> option) {
		return new VisiSuseraciveEnforceHasData(option);
	}
}
