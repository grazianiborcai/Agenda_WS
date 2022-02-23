package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

public final class StdStordagrSuccess extends ActionStdSuccessTemplate<StordagrInfo> {
	public StdStordagrSuccess(DeciTreeOption<StordagrInfo> option) {
		super(option);
	}
}
