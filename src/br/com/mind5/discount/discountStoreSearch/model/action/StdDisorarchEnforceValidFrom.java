package br.com.mind5.discount.discountStoreSearch.model.action;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDisorarchEnforceValidFrom extends ActionStdTemplate<DisorarchInfo> {

	public StdDisorarchEnforceValidFrom(DeciTreeOption<DisorarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<DisorarchInfo> buildVisitorHook(DeciTreeOption<DisorarchInfo> option) {
		return new VisiDisorarchEnforceValidFrom(option);
	}
}
