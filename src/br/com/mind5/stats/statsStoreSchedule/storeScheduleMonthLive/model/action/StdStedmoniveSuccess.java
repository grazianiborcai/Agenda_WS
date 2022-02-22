package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

public final class StdStedmoniveSuccess extends ActionStdSuccessTemplate<StedmoniveInfo> {
	public StdStedmoniveSuccess(DeciTreeOption<StedmoniveInfo> option) {
		super(option);
	}
}
