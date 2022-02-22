package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

public final class StdStedmoniveEnforceLChanged extends ActionStdTemplate<StedmoniveInfo> {

	public StdStedmoniveEnforceLChanged(DeciTreeOption<StedmoniveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StedmoniveInfo> buildVisitorHook(DeciTreeOption<StedmoniveInfo> option) {
		return new VisiStedmoniveEnforceLChanged(option);
	}
}
