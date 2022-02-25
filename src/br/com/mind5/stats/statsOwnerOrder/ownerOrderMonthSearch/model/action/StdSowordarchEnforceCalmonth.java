package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;

public final class StdSowordarchEnforceCalmonth extends ActionStdTemplate<SowordarchInfo> {

	public StdSowordarchEnforceCalmonth(DeciTreeOption<SowordarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowordarchInfo> buildVisitorHook(DeciTreeOption<SowordarchInfo> option) {
		return new VisiSowordarchEnforceCalmonth(option);
	}
}
