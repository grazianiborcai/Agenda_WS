package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;

public final class StdSowedulSowedulagrInsert extends ActionStdTemplate<SowedulInfo> {

	public StdSowedulSowedulagrInsert(DeciTreeOption<SowedulInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowedulInfo> buildVisitorHook(DeciTreeOption<SowedulInfo> option) {
		return new VisiSowedulSowedulagrInsert(option);
	}
}
