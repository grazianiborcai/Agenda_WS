package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

public final class StdSoweduliveDaoSelect extends ActionStdTemplate<SoweduliveInfo> {

	public StdSoweduliveDaoSelect(DeciTreeOption<SoweduliveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SoweduliveInfo> buildVisitorHook(DeciTreeOption<SoweduliveInfo> option) {
		return new VisiSoweduliveDaoSelect(option);
	}
}
