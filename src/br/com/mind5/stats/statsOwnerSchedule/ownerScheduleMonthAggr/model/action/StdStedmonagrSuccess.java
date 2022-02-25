package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;

public final class StdStedmonagrSuccess extends ActionStdSuccessTemplate<SowedulagrInfo> {
	public StdStedmonagrSuccess(DeciTreeOption<SowedulagrInfo> option) {
		super(option);
	}
}
