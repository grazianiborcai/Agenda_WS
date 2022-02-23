package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;

public final class StdStoronSuccess extends ActionStdSuccessTemplate<StoronInfo> {
	
	public StdStoronSuccess(DeciTreeOption<StoronInfo> option) {
		super(option);
	}
}
