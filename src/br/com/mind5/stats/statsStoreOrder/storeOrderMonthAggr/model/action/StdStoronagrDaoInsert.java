package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

public final class StdStoronagrDaoInsert extends ActionStdTemplate<StoronagrInfo> {

	public StdStoronagrDaoInsert(DeciTreeOption<StoronagrInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoronagrInfo> buildVisitorHook(DeciTreeOption<StoronagrInfo> option) {
		return new VisiStoronagrDaoInsert(option);
	}
}
