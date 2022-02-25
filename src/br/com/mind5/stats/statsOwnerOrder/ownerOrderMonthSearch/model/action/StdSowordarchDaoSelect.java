package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;

public final class StdSowordarchDaoSelect extends ActionStdTemplate<SowordarchInfo> {

	public StdSowordarchDaoSelect(DeciTreeOption<SowordarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowordarchInfo> buildVisitorHook(DeciTreeOption<SowordarchInfo> option) {
		return new VisiSowordarchDaoSelect(option);
	}
}
