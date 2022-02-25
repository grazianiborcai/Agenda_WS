package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchhInfo;

public final class StdSowedularchEnforceCalmonth extends ActionStdTemplate<SowedularchhInfo> {

	public StdSowedularchEnforceCalmonth(DeciTreeOption<SowedularchhInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowedularchhInfo> buildVisitorHook(DeciTreeOption<SowedularchhInfo> option) {
		return new VisiSowedularchEnforceCalmonth(option);
	}
}
