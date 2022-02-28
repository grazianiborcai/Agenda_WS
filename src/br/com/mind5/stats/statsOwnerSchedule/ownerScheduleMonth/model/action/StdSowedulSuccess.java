package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;

public final class StdSowedulSuccess extends ActionStdSuccessTemplate<SowedulInfo> {
	
	public StdSowedulSuccess(DeciTreeOption<SowedulInfo> option) {
		super(option);
	}
}
