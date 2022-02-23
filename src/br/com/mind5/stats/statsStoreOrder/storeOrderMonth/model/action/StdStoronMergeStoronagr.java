package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;

public final class StdStoronMergeStoronagr extends ActionStdTemplate<StoronInfo> {

	public StdStoronMergeStoronagr(DeciTreeOption<StoronInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoronInfo> buildVisitorHook(DeciTreeOption<StoronInfo> option) {
		return new VisiStoronMergeStoronagr(option);
	}
}
