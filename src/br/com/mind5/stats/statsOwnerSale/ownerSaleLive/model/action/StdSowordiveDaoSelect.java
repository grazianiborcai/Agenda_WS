package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;

public final class StdSowordiveDaoSelect extends ActionStdTemplate<SowaliveInfo> {

	public StdSowordiveDaoSelect(DeciTreeOption<SowaliveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SowaliveInfo> buildVisitorHook(DeciTreeOption<SowaliveInfo> option) {
		return new VisiSowordiveDaoSelect(option);
	}
}
