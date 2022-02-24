package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;

public final class StdSowordagrSuccess extends ActionStdSuccessTemplate<SowordagrInfo> {
	public StdSowordagrSuccess(DeciTreeOption<SowordagrInfo> option) {
		super(option);
	}
}
