package br.com.mind5.stats.statsOwnerSale.ownerSale.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;

public final class StdSowalEnforceZerofy extends ActionStdTemplate<SowalInfo> {

	public StdSowalEnforceZerofy(DeciTreeOption<SowalInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowalInfo> buildVisitorHook(DeciTreeOption<SowalInfo> option) {
		return new VisiSowalEnforceZerofy(option);
	}
}
