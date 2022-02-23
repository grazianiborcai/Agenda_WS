package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;

public final class StdStordSuccess extends ActionStdSuccessTemplate<StordInfo> {
	
	public StdStordSuccess(DeciTreeOption<StordInfo> option) {
		super(option);
	}
}
