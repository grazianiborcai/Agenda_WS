package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;

public final class StdStordiveMergeToSelect extends ActionStdTemplate<StordiveInfo> {

	public StdStordiveMergeToSelect(DeciTreeOption<StordiveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StordiveInfo> buildVisitorHook(DeciTreeOption<StordiveInfo> option) {
		return new VisiStordiveMergeToSelect(option);
	}
}
