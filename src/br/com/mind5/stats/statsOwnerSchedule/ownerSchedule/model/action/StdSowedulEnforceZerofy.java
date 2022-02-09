package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulInfo;

public final class StdSowedulEnforceZerofy extends ActionStdTemplate<SowedulInfo> {

	public StdSowedulEnforceZerofy(DeciTreeOption<SowedulInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowedulInfo> buildVisitorHook(DeciTreeOption<SowedulInfo> option) {
		return new VisiSowedulEnforceZerofy(option);
	}
}
