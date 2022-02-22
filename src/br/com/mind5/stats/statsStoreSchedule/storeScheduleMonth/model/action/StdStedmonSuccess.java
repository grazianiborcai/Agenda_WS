package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;

public final class StdStedmonSuccess extends ActionStdSuccessTemplate<StedmonInfo> {
	
	public StdStedmonSuccess(DeciTreeOption<StedmonInfo> option) {
		super(option);
	}
}
