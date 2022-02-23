package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

public final class StdStordagrMergeToSelect extends ActionStdTemplate<StordagrInfo> {

	public StdStordagrMergeToSelect(DeciTreeOption<StordagrInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StordagrInfo> buildVisitorHook(DeciTreeOption<StordagrInfo> option) {
		return new VisiStordagrMergeToSelect(option);
	}
}
