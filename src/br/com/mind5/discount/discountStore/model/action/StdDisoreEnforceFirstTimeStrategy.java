package br.com.mind5.discount.discountStore.model.action;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDisoreEnforceFirstTimeStrategy extends ActionStdTemplate<DisoreInfo> {

	public StdDisoreEnforceFirstTimeStrategy(DeciTreeOption<DisoreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<DisoreInfo> buildVisitorHook(DeciTreeOption<DisoreInfo> option) {
		return new VisiDisoreEnforceFirstTimeStrategy(option);
	}
}
