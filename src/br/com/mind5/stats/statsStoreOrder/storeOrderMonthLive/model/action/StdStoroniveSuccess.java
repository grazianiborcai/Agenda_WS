package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;

public final class StdStoroniveSuccess extends ActionStdSuccessTemplate<StoroniveInfo> {
	public StdStoroniveSuccess(DeciTreeOption<StoroniveInfo> option) {
		super(option);
	}
}
