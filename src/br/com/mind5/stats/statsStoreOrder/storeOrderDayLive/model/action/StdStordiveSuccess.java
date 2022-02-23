package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;

public final class StdStordiveSuccess extends ActionStdSuccessTemplate<StordiveInfo> {
	public StdStordiveSuccess(DeciTreeOption<StordiveInfo> option) {
		super(option);
	}
}
