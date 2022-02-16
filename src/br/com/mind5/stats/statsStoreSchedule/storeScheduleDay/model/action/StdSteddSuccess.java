package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;

public final class StdSteddSuccess extends ActionStdSuccessTemplate<SteddInfo> {
	
	public StdSteddSuccess(DeciTreeOption<SteddInfo> option) {
		super(option);
	}
}
