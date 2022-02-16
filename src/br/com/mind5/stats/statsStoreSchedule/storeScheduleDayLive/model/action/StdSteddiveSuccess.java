package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;

public final class StdSteddiveSuccess extends ActionStdSuccessTemplate<SteddiveInfo> {
	public StdSteddiveSuccess(DeciTreeOption<SteddiveInfo> option) {
		super(option);
	}
}
