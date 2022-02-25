package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;

public final class StdSowordagrMergeSowordarchMonth extends ActionStdTemplate<SowordagrInfo> {

	public StdSowordagrMergeSowordarchMonth(DeciTreeOption<SowordagrInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowordagrInfo> buildVisitorHook(DeciTreeOption<SowordagrInfo> option) {
		return new VisiSowordagrDaoDelete(option);
	}
}
