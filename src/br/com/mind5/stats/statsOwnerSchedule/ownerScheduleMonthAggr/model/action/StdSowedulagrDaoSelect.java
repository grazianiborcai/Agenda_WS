package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;

public final class StdSowedulagrDaoSelect extends ActionStdTemplate<SowedulagrInfo> {

	public StdSowedulagrDaoSelect(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowedulagrInfo> buildVisitorHook(DeciTreeOption<SowedulagrInfo> option) {
		return new VisiSowedulagrDaoSelect(option);
	}
}
