package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;

public final class StdStoroniveMergeCalonth extends ActionStdTemplate<StoroniveInfo> {

	public StdStoroniveMergeCalonth(DeciTreeOption<StoroniveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoroniveInfo> buildVisitorHook(DeciTreeOption<StoroniveInfo> option) {
		return new VisiStoroniveMergeCalonth(option);
	}
}
