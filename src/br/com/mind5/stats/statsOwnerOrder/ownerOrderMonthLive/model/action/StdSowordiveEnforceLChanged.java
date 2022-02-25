package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;

public final class StdSowordiveEnforceLChanged extends ActionStdTemplate<SowordiveInfo> {

	public StdSowordiveEnforceLChanged(DeciTreeOption<SowordiveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowordiveInfo> buildVisitorHook(DeciTreeOption<SowordiveInfo> option) {
		return new VisiSowordiveEnforceLChanged(option);
	}
}
