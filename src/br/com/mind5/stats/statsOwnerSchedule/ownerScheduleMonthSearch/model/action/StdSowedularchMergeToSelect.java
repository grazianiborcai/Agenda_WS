package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;

public final class StdSowedularchMergeToSelect extends ActionStdTemplate<SowedularchInfo> {

	public StdSowedularchMergeToSelect(DeciTreeOption<SowedularchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowedularchInfo> buildVisitorHook(DeciTreeOption<SowedularchInfo> option) {
		return new VisiSowedularchMergeToSelect(option);
	}
}
