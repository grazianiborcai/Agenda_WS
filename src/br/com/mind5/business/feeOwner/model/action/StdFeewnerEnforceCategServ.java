package br.com.mind5.business.feeOwner.model.action;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeewnerEnforceCategServ extends ActionStdTemplate<FeewnerInfo> {

	public StdFeewnerEnforceCategServ(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FeewnerInfo> buildVisitorHook(DeciTreeOption<FeewnerInfo> option) {
		return new VisiFeewnerEnforceCategServ(option);
	}
}
