package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;

public final class StdSteddMergeCalateMonth extends ActionStdTemplate<SteddInfo> {

	public StdSteddMergeCalateMonth(DeciTreeOption<SteddInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SteddInfo> buildVisitorHook(DeciTreeOption<SteddInfo> option) {
		return new VisiSteddMergeCalateMonth(option);
	}
}
