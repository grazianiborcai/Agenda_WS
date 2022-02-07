package br.com.mind5.stats.statsUserAccount.userAccount.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;

public final class StdSuseracEnforceZerofy extends ActionStdTemplate<SuseracInfo> {

	public StdSuseracEnforceZerofy(DeciTreeOption<SuseracInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SuseracInfo> buildVisitorHook(DeciTreeOption<SuseracInfo> option) {
		return new VisiSuseracEnforceZerofy(option);
	}
}
