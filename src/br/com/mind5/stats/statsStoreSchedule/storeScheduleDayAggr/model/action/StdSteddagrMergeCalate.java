package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;

public final class StdSteddagrMergeCalate extends ActionStdTemplate<SteddagrInfo> {

	public StdSteddagrMergeCalate(DeciTreeOption<SteddagrInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SteddagrInfo> buildVisitorHook(DeciTreeOption<SteddagrInfo> option) {
		return new VisiSteddagrMergeCalate(option);
	}
}
