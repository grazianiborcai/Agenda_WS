package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;

public final class StdSowedulagrSuccess extends ActionStdSuccessTemplate<SowedulagrInfo> {
	public StdSowedulagrSuccess(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
}
