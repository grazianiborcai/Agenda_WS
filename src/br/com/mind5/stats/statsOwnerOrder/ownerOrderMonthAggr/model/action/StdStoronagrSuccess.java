package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

public final class StdStoronagrSuccess extends ActionStdSuccessTemplate<StoronagrInfo> {
	public StdStoronagrSuccess(DeciTreeOption<StoronagrInfo> option) {
		super(option);
	}
}
