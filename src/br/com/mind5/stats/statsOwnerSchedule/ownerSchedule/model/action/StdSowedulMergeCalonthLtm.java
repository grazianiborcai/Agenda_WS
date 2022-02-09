package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulInfo;

public final class StdSowedulMergeCalonthLtm extends ActionStdTemplate<SowedulInfo> {

	public StdSowedulMergeCalonthLtm(DeciTreeOption<SowedulInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowedulInfo> buildVisitorHook(DeciTreeOption<SowedulInfo> option) {
		return new VisiSowedulMergeCalonthLtm(option);
	}
}
