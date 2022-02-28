package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;

public final class StdSowedulMergeStolis extends ActionStdTemplate<SowedulInfo> {

	public StdSowedulMergeStolis(DeciTreeOption<SowedulInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowedulInfo> buildVisitorHook(DeciTreeOption<SowedulInfo> option) {
		return new VisiSowedulMergeStolis(option);
	}
}
