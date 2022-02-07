package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;

public final class StdSowordiveDaoSelect extends ActionStdTemplate<SowordiveInfo> {

	public StdSowordiveDaoSelect(DeciTreeOption<SowordiveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowordiveInfo> buildVisitorHook(DeciTreeOption<SowordiveInfo> option) {
		return new VisiSowordiveDaoSelect(option);
	}
}
