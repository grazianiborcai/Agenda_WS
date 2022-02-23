package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;

public final class StdStordEnforceZerofy extends ActionStdTemplate<StordInfo> {

	public StdStordEnforceZerofy(DeciTreeOption<StordInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StordInfo> buildVisitorHook(DeciTreeOption<StordInfo> option) {
		return new VisiStordEnforceZerofy(option);
	}
}
