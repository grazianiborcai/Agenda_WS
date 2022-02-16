package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;

public final class StdSteddagrSuccess extends ActionStdSuccessTemplate<SteddagrInfo> {
	public StdSteddagrSuccess(DeciTreeOption<SteddagrInfo> option) {
		super(option);
	}
}
