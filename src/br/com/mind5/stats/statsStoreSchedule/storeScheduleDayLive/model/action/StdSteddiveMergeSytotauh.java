package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;

public final class StdSteddiveMergeSytotauh extends ActionStdTemplate<SteddiveInfo> {

	public StdSteddiveMergeSytotauh(DeciTreeOption<SteddiveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SteddiveInfo> buildVisitorHook(DeciTreeOption<SteddiveInfo> option) {
		return new VisiSteddiveMergeSytotauh(option);
	}
}
