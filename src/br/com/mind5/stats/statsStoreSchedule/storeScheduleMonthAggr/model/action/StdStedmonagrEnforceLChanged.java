package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class StdStedmonagrEnforceLChanged extends ActionStdTemplate<StedmonagrInfo> {

	public StdStedmonagrEnforceLChanged(DeciTreeOption<StedmonagrInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StedmonagrInfo> buildVisitorHook(DeciTreeOption<StedmonagrInfo> option) {
		return new VisiStedmonagrEnforceLChanged(option);
	}
}
