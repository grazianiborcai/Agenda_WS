package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;

public final class StdStedmonMergeCalonthLtm extends ActionStdTemplate<StedmonInfo> {

	public StdStedmonMergeCalonthLtm(DeciTreeOption<StedmonInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StedmonInfo> buildVisitorHook(DeciTreeOption<StedmonInfo> option) {
		return new VisiStedmonMergeCalonthLtm(option);
	}
}
