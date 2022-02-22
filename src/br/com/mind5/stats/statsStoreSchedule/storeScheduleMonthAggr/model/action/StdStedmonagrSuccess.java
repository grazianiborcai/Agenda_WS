package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class StdStedmonagrSuccess extends ActionStdSuccessTemplate<StedmonagrInfo> {
	public StdStedmonagrSuccess(DeciTreeOption<StedmonagrInfo> option) {
		super(option);
	}
}
