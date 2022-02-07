package br.com.mind5.stats.statsOwnerUser.ownerUser.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;

public final class StdSowusEnforceZerofy extends ActionStdTemplate<SowusInfo> {

	public StdSowusEnforceZerofy(DeciTreeOption<SowusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowusInfo> buildVisitorHook(DeciTreeOption<SowusInfo> option) {
		return new VisiSowusEnforceZerofy(option);
	}
}
